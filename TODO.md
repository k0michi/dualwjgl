# TODO

## Context
- [x] `GLContext.getCapabilities()` and the rest of GLContext
- [x] `ContextCapabilities`

## OpenAL
- [ ] `AL.create` / `AL.destroy` (closes only what `AL.create` opened; leaves the library to ALC)
- [ ] `AL.isCreated`, `AL.getContext`, `AL.getDevice`
- [ ] ALC10 / ALC11: `ALCdevice` / `ALCcontext` wrappers, handle-to-wrapper table
- [ ] EFX10

## OpenCL
- [ ] Rewrite `CallbackUtil` (Java-side ID table, `Callback.free()` lifetime)
- [ ] `CLEventCallback.setRegistry`, `CLProgramCallback.setContext`, `CLNativeKernel` argument block
- [ ] `CL.getHostBuffer`, `CL10.ncl*` overloads, `CLCapabilities` extension flags
- [ ] Decide `InfoUtilFactory`'s `CLCapabilities.clCreate*` fields (patch or merger rewrite)
- [ ] CL bindings (CL10/11/12, extensions): extend R3 (`@PointerWrapper` with params, `@Code`)
- [ ] Functions LWJGL 3 also has that LWJGL 2 registers objects in (`clGetPlatformIDs`, ...)
- [ ] `CLFunctionAddress`, `APPLEContextLoggingUtil`, `CLPrintfCallback`
- [ ] `CL.isCreated`

## OpenGL
- [ ] Debug output callbacks (KHR, ARB, AMD) and their callback classes
- [ ] `OpenGLException`, `Util.checkGLError`
- [ ] Remaining constructors (`ARBProgram`, `NVProgram`, `ARBBufferObject`)
- [ ] `glCreateSyncFromCLeventARB`, `glMapTexture2DINTEL`, `glPathTexGenNV`
- [ ] Internal classes: `DrawableGL`, `ContextGL`, `PeerInfo`

## OpenGL ES
- [ ] Everything (5 stubs, `Display.create(PixelFormatLWJGL, ...)`)

## Display
- [ ] Shared contexts: `SharedDrawable`, `Pbuffer`
- [x] `setParent` / AWT embedding, `AWTGLCanvas`: not supported, throws
- [ ] `setDisplayConfiguration`
- [ ] `Drawable.setCLSharingProperties`

## Input
- [ ] Controllers (JInput)
- [ ] Animated cursors on Linux

## lwjgl_util
- [ ] `org.lwjgl.util.mapped`
- [ ] `WaveData`

## Verification
- [ ] Comparison tests for hand-written code (`TODO(verify)`)
- [ ] Display and input on Windows and Linux
- [ ] Display and input with real keyboard and mouse
- [ ] Window-opening checks in CI

## Build
- [ ] `extractLwjgl2Sources` not rerunning when its includes change
