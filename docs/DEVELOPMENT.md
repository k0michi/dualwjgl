# Development notes

Internal notes on how lwjgl2w3 is built. For what the project is, see the [README](../README.md).

## Layout

| Project | Role |
|---|---|
| `inject-api` | Annotations read by the merger (`@Widen`, `@Wrap`, `@Around`, `@Hidden`, `@Into`, `@Generated`, `@Todo`). Build-time only. |
| `compat` | The LWJGL 2 implementation, written against LWJGL 3 (and SDL). |
| `merger` | ASM tool that merges `compat` into the LWJGL 3 jars. |
| `dist` | Runs the merger: `build/patched/*.jar`. |
| `verify` | Link tests (see below). |
| `stubgen` | Writes `compat/src/generated/java`: an implementation or a `@Todo` stub for every LWJGL 2 member LWJGL 3 lacks. |

### Writing compat code

- **LWJGL 2-only classes** (`Sys`, `LWJGLException`, later `Display`, `Keyboard`, ...) go in `compat/src/main/java`, in their
  real package. The merger adds them to the LWJGL 3 jar that owns the package.
- **Members of classes LWJGL 3 also has** (`BufferUtils`, `GL11`, ...) go in `compat/src/inject/java` as
  `com.koyomiji.lwjgl2w3.inject.<package>.<Name>`. The merger copies their members into `<package>.<Name>` and remaps references.
  - Adding a member that LWJGL 3 already declares (same name and descriptor) is an error.
  - `@Widen` on a member LWJGL 3 already declares: keep LWJGL 3's member, only widen its access.
  - `@Wrap` on a method LWJGL 3 already declares: replace it, keeping the original as `<name>$lwjgl3` (synthetic) for
    the inject class to call (declare it `abstract` there, or `static native` for a static method; either is only
    declared, not merged). Every caller, LWJGL 3's own included, goes through the
    wrapper; e.g. `PointerBuffer.create(...)` sends LWJGL 2 subclasses through `newInstance`.
  - `@Around(enter, exit)` on an inject class: once everything is merged, every instance method of the target calls
    `enter` first and `exit` on return or exception, and inherited overridable methods get synthetic overrides so that
    calls on the target always go through such a pair. PointerBuffer uses it to keep LWJGL 2's NIO views in sync.
  - `@Hidden`: emit as synthetic, so LWJGL 2 binaries link to it but javac does not see it (prevents overload hijacking
    of LWJGL 3 source).
  - Nested classes in inject classes are not supported yet.
  - An `@Into` inject class may live in the target's own package (e.g. `org.lwjgl.PointerBufferFragment`) to reach
    package-private classes there.

When LWJGL 2 and LWJGL 3 behave differently for the same signature, LWJGL 3 wins.
PointerBuffer always holds native-order pointers, whatever the order of the ByteBuffer it is created from, as LWJGL 3's
does (`DEVIATION(pointer-buffer-native-order)`). This is a project decision: LWJGL 2 kept the source's order, which native
code cannot read, so a PointerBuffer over e.g. `ByteBuffer.allocateDirect(n)` without `order(nativeOrder())` only worked
in LWJGL 2 as long as nothing native used it.
Strings follow LWJGL 3 too: each function's strings are encoded as LWJGL 3 encodes them (ASCII or UTF-8), where LWJGL 2
truncated every char to a byte (`DEVIATION(text-encoding)`).

### Comment markers

Greppable markers in comments, each `KIND(tag)` followed by an explanation. The tag names one decision; the same tag
marks every place that decision affects.

- **`DEVIATION(tag)`**: an LWJGL 2 binary, linked against the patched jars, behaves differently from LWJGL 2. Only what a
  binary compiled against LWJGL 2.9.3 can observe counts: a difference that only appears once LWJGL 2 source is
  recompiled against the patched jars (javac then picks LWJGL 3's member of the same signature, which wins by policy)
  is not a deviation, and is documented in a plain comment. Deviations in use:
  - `spec-fix`: LWJGL 2 declared the function against the wrong signature (a spec draft, a wrong type); the overload
    calls the function as the spec defines it.
  - `unbound`: LWJGL 3 does not bind the function, so it is unsupported, as LWJGL 2 reports a function the driver
    lacks, even when the driver has it. Generated unsupported members (`UnsupportedRule`) are all of this kind.
  - `text-encoding`: strings are encoded as LWJGL 3 encodes that function's (ASCII or UTF-8), where LWJGL 2 truncated
    every char to a byte; only non-ASCII text differs.
  - `pointer-buffer-native-order`: PointerBuffer reads and writes native order (the decision above), the static
    `PointerBuffer.put(ByteBuffer, long)` and `put(ByteBuffer, int, long)` included, which are LWJGL 3's (same
    descriptors). Those write at the target's address, which also crashes the JVM for a heap buffer, where LWJGL 2 wrote
    through `ByteBuffer.putLong`/`putInt`.
  - `out-of-scope`: LWJGL 2 API for extensions LWJGL 3 does not cover (see the README) behaves as in LWJGL 2 where the
    extension was missing: `APPLEContextLoggingUtil`'s callbacks are null and `CL_APPLE_ContextLoggingFunctions` is
    false; `CLPrintfCallback` can be created but `clSetPrintfCallback` throws "Function is not supported".
    `org.lwjgl.util.mapped` (lwjgl_util) is not supported at all: stubgen generates every member throwing
    `UnsupportedOperationException` ("org.lwjgl.util.mapped is not supported"), as listed in
    `StubWriter.UNSUPPORTED_PACKAGES`. It rewrote classes at run time with an ASM prerelease (4.0_RC1) the program had
    to bring, and reached memory through `sun.misc.Unsafe`.
  - `awt`: AWT embedding (`AWTGLCanvas`, `Display.setParent` with a parent) throws `LWJGLException`.
  - `pbuffer`: `Pbuffer.getCapabilities()` is 0 and its constructors throw `LWJGLException`, as LWJGL 2 did where the
    platform had no pbuffers; SDL has no off-screen drawable. `RenderTexture` is LWJGL 2's, unchanged.
  - `cursor-native-animation`: cursors report `CURSOR_ANIMATION` everywhere and an animated `Cursor` is one SDL animated
    cursor; LWJGL 2 animated natively only on Linux and switched single images from Java elsewhere.
  - `controllers-sdl`: Controllers are SDL's gamepads (standard layout) and joysticks, not JInput's, whose names, order
    and ranges varied by platform; JInput is not needed.
  - `display-configuration`: `Display.setDisplayConfiguration` (gamma) throws "Display configuration not supported", as
    LWJGL 2 did on platforms without a gamma ramp; SDL 3 has no gamma API.
  - `shared-context`: SDL shares a new context only with the current one, so creating a context shared with one current
    on another thread throws; LWJGL 2 created it.
  - `explicit-init`: `CL.create()` is LWJGL 3's (same signature), which throws once the library is loaded, where LWJGL
    2's returned. Unless `org.lwjgl.opencl.explicitInit` is set, LWJGL 3 loads it as `CL` initializes, so an LWJGL 2
    program's `CL.create()` throws; run it with `-Dorg.lwjgl.opencl.explicitInit=true` (a system property, so it can be
    set outside the program, e.g. in `JAVA_TOOL_OPTIONS`). `AL.create` is LWJGL 2's own and works either way: it loads
    the library only if nothing has.
  - `keyboard-physical-keys`: key codes name physical keys on every platform; LWJGL 2 on Linux followed the layout.
  - `macos-first-thread`: on macOS the Display needs `-XstartOnFirstThread` (SDL's video runs on the first thread).
- **`TODO(area)`**: work left in hand-written code, `area` as for `@Todo` (`cl`, `sdl`, ...). Generated stubs use the
  `@Todo("<area>")` annotation instead, which the merger counts.
- **`TODO(verify)`**: hand-written code that no test compares with LWJGL 2's behaviour (DelegationTest only covers
  generated members).

### PointerBuffer

LWJGL 2's PointerBuffer keeps its state in NIO views (`pointers`, `view`, `view32`, `view64`, protected), LWJGL 3's in
CustomBuffer's fields. Buffers made by LWJGL 2's constructors get `pointers` (what `getBuffer()` returns, in native
order), and the views too when they are an LWJGL 2 subclass, which can move the views. For those, `@Around` hooks pull
the view's position, limit and mark on entry to every PointerBuffer method when the view differs from the state last
synced, and push the buffer's on exit; the mark goes through `sun.misc.Unsafe`, as LWJGL 3 reads `Buffer.address`.
LWJGL 3's own buffers have no view and pay a null check per call.

`./gradlew :verify:pointerBufferBench` compares PointerBuffer's speed on the original and the patched jars.

### Display

`org.lwjgl.opengl.Display` is written on LWJGL 3's SDL 3 bindings (`compat/src/main`): one SDL window, and as in LWJGL 2
a `DrawableGL` with a `ContextGL`. `ContextGL` and `DrawableGL` are LWJGL 2's, written on SDL's GL contexts in place of
its platform context implementations; the peer (`SDLPeerInfo`) is an SDL window. `DisplayMode`, `PixelFormat`,
`ContextAttribs`, `Drawable`, `Sync`, `PeerInfo`, `SharedDrawable`, `OpenGLException` and `Util` are LWJGL 2's sources,
unchanged. Input goes through `SDLInput`, LWJGL 2's `InputImplementation` (what its platform display
classes implemented), which Display feeds SDL's events; `Mouse`, `Keyboard` and their helpers are LWJGL 2's sources, and
`Cursor` is LWJGL 2's with animations handed over whole. Keys map SDL scancodes to LWJGL 2's key codes (`SDLKeys`), characters come from SDL's text input. OpenGL ES
is still TODO(sdl); Pbuffers are not supported (`DEVIATION(pbuffer)`); AWT embedding is not supported (`DEVIATION(awt)`).

`Controllers` is written on SDL's gamepad and joystick API (`Controller` and `ControllerEvent` are LWJGL 2's sources).
`./gradlew :verify:controllersCheck` drives an SDL virtual gamepad and joystick through it.

Not part of check, as they open a window: `./gradlew :verify:displayDemo` (`-Pframes=N` to stop) runs an LWJGL 2
program; `./gradlew :verify:displayInputCheck` feeds the Display synthetic SDL events and checks LWJGL 2's Mouse and
Keyboard.

### lwjgl_util

lwjgl_util is LWJGL 2's sources, unchanged but for `WaveData`, filtered as it is extracted: its `create(URL)` read
through the JDK-internal `com.sun.media.sound.WaveFileReader`, and reads through `javax.sound.sampled.AudioSystem`, as its
other `create` methods do. `org.lwjgl.util.mapped` is not supported (`DEVIATION(out-of-scope)`).

### Debug output callbacks

`KHRDebugCallback`, `ARBDebugOutputCallback` and `AMDDebugOutputCallback` are LWJGL 2's sources. Their pointer is a fixed
function from `CallbackUtil` (`org.lwjgl.opengl`, `compat/src/main`), one LWJGL 3 callback per extension created once,
as LWJGL 2's C functions were; `glDebugMessageCallback(KHRDebugCallback)` and the ARB and AMD functions pass the
Handler's reference (an ID in CallbackUtil's table) as userParam, and `ContextGL` drops a context's references as it
destroys it. Only checked by calling the fixed functions directly: macOS has none of the extensions.

### OpenAL

LWJGL 2's `ALCdevice` and `ALCcontext` are its sources, unchanged; they wrap LWJGL 3's handles. `ALObjects`
(`compat/src/main`) holds LWJGL 2's handle-to-wrapper tables and the bodies of its `AL`, `ALC10` and `ALC11` members, with
LWJGL 3's functions in place of the natives; the `@Into` fragments in `compat/src/inject/java/org/lwjgl/openal` forward
to it. LWJGL 3's `ALC` owns the library, so `AL.create` loads it only when nothing has (explicit init), and makes the
first context made current create AL's capabilities, which LWJGL 3 needs a current context for. `AL.destroy` (LWJGL 3's
is package-private, called by `ALC.destroy`, and is wrapped) closes only the context and device `AL.create` opened, then
clears the capabilities. Unlike LWJGL 2's, it leaves the library loaded: LWJGL 3's ALC keeps the first library's function
pointers for good (`ALC.ICDStatic`), so loading it again after unloading crashes where the library really unloads
(Linux), and LWJGL 2 programs destroy and create AL again to reset sound.

The link tests open devices on OpenAL Soft's null backend (`ALSOFT_DRIVERS=null`).

### OpenCL

The CL object model (`CLPlatform`, `CLContext`, `CLObjectRegistry`, `InfoUtil*`, ...) is LWJGL 2's sources. One change
is in `InfoUtilFactory`, filtered as it is extracted (the other filtered source is `WaveData`, below): it read LWJGL 2's static `CLCapabilities.clCreateContext`
(and `clCreateImage2D`/`3D`), which LWJGL 3's `CLCapabilities` cannot have next to its instance fields of those names,
and calls `CL.getFunctionAddress` instead. Around it:

- `CallbackUtil` (`compat/src/main`) keeps LWJGL 2's user_data protocol with a Java table of IDs in place of JNI global
  references. The callback classes (`compat/src/replace`) are LWJGL 3 Callbacks, so they are their own native functions;
  the one-shot ones (event, program, memory object destructor, native kernel) delete their reference after the call,
  as LWJGL 2's trampolines did. A closure given to `createGlobalRef` is freed once its callback object is collected.
- `clGetPlatformIDs` and `clGetGLContextInfoKHR` have LWJGL 2's signatures, so LWJGL 3's are used; they are wrapped to
  add LWJGL 2's side effect, registering the CLPlatform and CLDevice wrappers the object model looks up.
- `CLCapabilities` gets LWJGL 2's static extension flags (whether the library exports the extension's functions) and
  the per-object capabilities; `CL` gets `isCreated`, `getFunctionAddress` and `getHostBuffer`; `CL10` gets the
  `ncl*` overloads with LWJGL 2's trailing function pointer that `InfoUtilFactory` calls.

### Generated code

`./gradlew :stubgen:generateStubs` rewrites `compat/src/generated/java` from scratch; never edit it. For each LWJGL 2
member LWJGL 3 does not provide it writes a delegation when a rule proves one (R1: an LWJGL 3 method with the same
signature that makes the same native calls; R2: LWJGL 3's raw `n` method for a single native call; R3, for OpenGL
classes: LWJGL 2's generator template for the method, from the tagged LWJGL 2 source archive, expanded into a call to
the raw `n` method), and otherwise a stub marked `@Todo("<area>")`. Every rule checks its result against the native
calls LWJGL 2's own bytecode makes (`NativeTrace`); `stubgen/build/template-declines.tsv` says why R3 left methods in
its scope alone. Hand-written code goes in
`main`, `inject` or `replace` and wins: a hand-written member overrides the generated one, and a hand-written whole
class keeps stubgen from generating that class. The merger prints the `@Todo`s that remain.

## Verification

Every test tree is compiled twice and always run against the patched jars:

| Suite | Compiled against | Proves |
|---|---|---|
| `lwjgl2Test` | original LWJGL 2.9.3 | LWJGL 2 binaries link and work |
| `lwjgl3Test` | original LWJGL 3.4.3 | LWJGL 3 binaries still link and work |
| `lwjgl2SourceTest` | patched jars | LWJGL 2 source compiles |
| `lwjgl3SourceTest` | patched jars | LWJGL 3 source compiles |

```
./gradlew check
```

CI (`.github/workflows/ci.yml`) runs the same on Linux x64, macOS arm64 and Windows x64.

Versions are pinned in `gradle/libs.versions.toml`.
