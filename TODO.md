# TODO

## Context
- [x] `GLContext.getCapabilities()` and the rest of GLContext
- [x] `ContextCapabilities`

## OpenAL
- [x] `AL.create` / `AL.destroy` (closes only what `AL.create` opened; leaves the library to ALC)
- [x] `AL.isCreated`, `AL.getContext`, `AL.getDevice`
- [x] ALC10 / ALC11: `ALCdevice` / `ALCcontext` wrappers, handle-to-wrapper table
- [ ] EFX10 (6): generated, delegating to LWJGL 3's `EXTEfx`
- [ ] AL10 `alIsExtensionPresent(String)`, `alGetEnumValue(String)`: generated, delegating to the `CharSequence` ones

## OpenCL
- [x] Rewrite `CallbackUtil` (Java-side ID table, `Callback.free()` lifetime)
- [x] `CLEventCallback.setRegistry`, `CLProgramCallback.setContext`, `CLNativeKernel` argument block
- [x] `CL.getHostBuffer`, `CL10.ncl*` overloads, `CLCapabilities` extension flags
- [x] `InfoUtilFactory`'s `CLCapabilities.clCreate*` fields: filtered as extracted
- [ ] stubgen: write CL fragments in `org.lwjgl.opencl` (`@Into`), so that `@Code` reaches package-private members
- [ ] Decide how CL bindings are generated: extend R3 (`@Code`, `@PointerWrapper` with params, `@Check`), or carry over
  LWJGL 2's generated sources with `ncl*(..., function_pointer)` calls turned into LWJGL 3's `ncl*`
- [ ] CL bindings (CL10/11/12, CL10GL, extensions; 172)
- [x] Functions LWJGL 3 also has that LWJGL 2 registers objects in (`clGetPlatformIDs`, ...)
- [x] `CLFunctionAddress`
- [x] `APPLEContextLoggingUtil`, `CLPrintfCallback`: out of scope, as where the extension is missing
- [x] `CL.isCreated`
- [x] `CL.create()` once LWJGL 3 has loaded the library: throws as LWJGL 3; LWJGL 2 programs set `org.lwjgl.opencl.explicitInit`

## OpenGL
- [x] Debug output callbacks (KHR, ARB, AMD) and their callback classes
- [ ] Debug output callbacks with a real driver (Windows or Linux)
- [x] `OpenGLException`, `Util.checkGLError`
- [x] Remaining constructors (`ARBProgram`, `NVProgram`, `ARBBufferObject`)
- [ ] `glMapTexture2DINTEL`, `glPathTexGenNV`: hand-written
- [ ] `glCreateSyncFromCLeventARB`: hand-written, after the CL bindings (takes `CLEvent`)
- [x] Internal classes: `DrawableGL`, `ContextGL`, `PeerInfo`

## OpenGL ES
- [ ] Decide: supported, or not supported and throwing
- [ ] Everything (5 stubs, `Display.create(PixelFormatLWJGL, ...)`)

## Display
- [x] Shared contexts: `SharedDrawable`
- [x] `Pbuffer`: not supported, throws
- [x] `setParent` / AWT embedding, `AWTGLCanvas`: not supported, throws
- [x] `setDisplayConfiguration`: not supported, throws
- [ ] `Drawable.setCLSharingProperties`
- [ ] `XRandR` (8; LWJGL 2's Linux display internals, public): decide, e.g. not supported

## Input
- [x] Controllers: on SDL instead of JInput
- [x] Animated cursors: SDL's native animation on every platform

## lwjgl_util
- [x] `org.lwjgl.util.mapped`: not supported; every member throws (generated)
- [ ] `WaveData` (7): not generated; port (LWJGL 2's depends on `com.sun.media.sound`)

## Verification
- [ ] Comparison tests for hand-written code (`TODO(verify)`)
- [ ] Display and input on Windows and Linux
- [ ] Display and input with real keyboard and mouse
- [ ] Window-opening checks in CI

## Build
- [ ] `extractLwjgl2Sources` not rerunning when its includes change
