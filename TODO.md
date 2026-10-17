# TODO

## Context
- [x] `GLContext.getCapabilities()` and the rest of GLContext
- [x] `ContextCapabilities`

## OpenAL
- [x] `AL.create` / `AL.destroy` (closes only what `AL.create` opened; leaves the library to ALC)
- [x] `AL.isCreated`, `AL.getContext`, `AL.getDevice`
- [x] ALC10 / ALC11: `ALCdevice` / `ALCcontext` wrappers, handle-to-wrapper table
- [x] EFX10, and AL10's `String` functions: generated

## OpenCL
- [x] Rewrite `CallbackUtil` (Java-side ID table, `Callback.free()` lifetime)
- [x] `CLEventCallback.setRegistry`, `CLProgramCallback.setContext`, `CLNativeKernel` argument block
- [x] `CL.getHostBuffer`, `CL10.ncl*` overloads, `CLCapabilities` extension flags
- [x] `InfoUtilFactory`'s `CLCapabilities.clCreate*` fields: filtered as extracted
- [x] stubgen: write CL fragments in `org.lwjgl.opencl` (`@Into`), so that `@Code` reaches package-private members
- [x] CL bindings without Java side effects (getters, enqueues LWJGL 2 did not register events for): generated
- [x] CL bindings that also update the object model (register, retain, release, `new CL*`, callbacks): generated
  from LWJGL 2's templates (`@Code`, `@PointerWrapper`, `@Constant`) around the delegation
- [x] CL bindings whose arrays LWJGL 2's C made (program sources and binaries, `clCompileProgram`, `clGetProgramInfo`
  binaries, `clEnqueueMapImage`, `clEnqueueNativeKernel`, `clGetSupportedImageFormats`): hand-written
- [x] An LWJGL 2 program's OpenCL lifecycle end to end (lwjgl2Test, macOS)
- [ ] `clSetMemObjectDestructorAPPLE`: LWJGL 3 has no APPLE_SetMemObjectDestructor
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
- [x] `Drawable.setCLSharingProperties` (WGL, GLX, CGL; EGL as an extension)
- [ ] `Drawable.setCLSharingProperties` on Windows and Linux (WGL, GLX, EGL)
- [x] `XRandR`: not supported; every member throws (generated)

## Input
- [x] Controllers: on SDL instead of JInput
- [x] Animated cursors: SDL's native animation on every platform

## lwjgl_util
- [x] `org.lwjgl.util.mapped`: not supported; every member throws (generated)
- [x] `WaveData`: LWJGL 2's, `create(URL)` reading through `javax.sound.sampled.AudioSystem`

## Verification
- [ ] Comparison tests for hand-written code (`TODO(verify)`)
- [ ] Display and input on Windows and Linux
- [ ] Display and input with real keyboard and mouse
- [ ] Window-opening checks in CI

## Generation
- [x] One delegation rule (`DelegationRule`) to LWJGL 3's public methods, in place of R1/R2/R3; hand-written code calls
  public methods too, but for the `CL10.ncl*` overloads that stand in for LWJGL 2's natives
- [x] Parameters LWJGL 2's C transformed (`@Indirect`, `@PointerArray`) never delegated: the GL ones it had generated
  (`glTransformFeedbackVaryings`, `glGetUniformIndices`, `glCompileShaderIncludeARB`) passed packed strings as the
  pointer array; hand-written now

## Build
- [ ] `extractLwjgl2Sources` not rerunning when its includes change
