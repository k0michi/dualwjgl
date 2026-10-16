# TODO

## Context
- [x] `GLContext.getCapabilities()` and the rest of GLContext
- [x] `ContextCapabilities`

## OpenAL
- [x] `AL.create` / `AL.destroy` (closes only what `AL.create` opened; leaves the library to ALC)
- [x] `AL.isCreated`, `AL.getContext`, `AL.getDevice`
- [x] ALC10 / ALC11: `ALCdevice` / `ALCcontext` wrappers, handle-to-wrapper table
- [ ] EFX10

## OpenCL
- [x] Rewrite `CallbackUtil` (Java-side ID table, `Callback.free()` lifetime)
- [x] `CLEventCallback.setRegistry`, `CLProgramCallback.setContext`, `CLNativeKernel` argument block
- [x] `CL.getHostBuffer`, `CL10.ncl*` overloads, `CLCapabilities` extension flags
- [x] `InfoUtilFactory`'s `CLCapabilities.clCreate*` fields: filtered as extracted
- [ ] CL bindings (CL10/11/12, extensions): extend R3 (`@PointerWrapper` with params, `@Code`)
- [x] Functions LWJGL 3 also has that LWJGL 2 registers objects in (`clGetPlatformIDs`, ...)
- [x] `CLFunctionAddress`
- [ ] `APPLEContextLoggingUtil`, `CLPrintfCallback`
- [x] `CL.isCreated`
- [ ] `CL.create()` once LWJGL 3 has loaded the library (no explicit init): throws, where LWJGL 2's returned

## OpenGL
- [ ] Debug output callbacks (KHR, ARB, AMD) and their callback classes
- [x] `OpenGLException`, `Util.checkGLError`
- [ ] Remaining constructors (`ARBProgram`, `NVProgram`, `ARBBufferObject`)
- [ ] `glCreateSyncFromCLeventARB`, `glMapTexture2DINTEL`, `glPathTexGenNV`
- [x] Internal classes: `DrawableGL`, `ContextGL`, `PeerInfo`

## OpenGL ES
- [ ] Everything (5 stubs, `Display.create(PixelFormatLWJGL, ...)`)

## Display
- [x] Shared contexts: `SharedDrawable`
- [x] `Pbuffer`: not supported, throws
- [x] `setParent` / AWT embedding, `AWTGLCanvas`: not supported, throws
- [x] `setDisplayConfiguration`: not supported, throws
- [ ] `Drawable.setCLSharingProperties`

## Input
- [x] Controllers: on SDL instead of JInput
- [x] Animated cursors: SDL's native animation on every platform

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
