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
    the inject class to call (declare it `abstract` there). Every caller, LWJGL 3's own included, goes through the
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

`org.lwjgl.opengl.Display` is written on LWJGL 3's SDL 3 bindings (`compat/src/main`): one SDL window and OpenGL context,
made current with LWJGL 3's GL capabilities. `DisplayMode`, `PixelFormat`, `ContextAttribs`, `Drawable` and `Sync` are
LWJGL 2's sources, unchanged. Input goes through `SDLInput`, LWJGL 2's `InputImplementation` (what its platform display
classes implemented), which Display feeds SDL's events; `Mouse`, `Cursor` and their helpers are LWJGL 2's sources. Keyboard,
shared contexts, OpenGL ES and AWT embedding are still TODO(sdl).

Not part of check, as they open a window: `./gradlew :verify:displayDemo` (`-Pframes=N` to stop) runs an LWJGL 2
program; `./gradlew :verify:displayInputCheck` feeds the Display synthetic SDL events and checks LWJGL 2's Mouse.

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
