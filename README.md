# lwjgl2w3

**LWJGL 2 *with* 3**: patched LWJGL 3 jars that link both as LWJGL 3 and as LWJGL 2 (2.9.3).
Unofficial; not affiliated with the LWJGL project.

## Layout

| Project | Role |
|---|---|
| `inject-api` | Annotations used by inject classes (`@Widen`, `@Hidden`). Build-time only. |
| `compat` | The LWJGL 2 implementation, written against LWJGL 3 (and SDL). |
| `merger` | ASM tool that merges `compat` into the LWJGL 3 jars. |
| `dist` | Runs the merger: `build/patched/*.jar`. |
| `verify` | Link tests (see below). |

### Writing compat code

- **LWJGL 2-only classes** (`Sys`, `LWJGLException`, later `Display`, `Keyboard`, ...) go in `compat/src/main/java`, in their
  real package. The merger adds them to the LWJGL 3 jar that owns the package.
- **Members of classes LWJGL 3 also has** (`BufferUtils`, `GL11`, ...) go in `compat/src/inject/java` as
  `com.koyomiji.lwjgl2w3.inject.<package>.<Name>`. The merger copies their members into `<package>.<Name>` and remaps references.
  - Adding a member that LWJGL 3 already declares (same name and descriptor) is an error.
  - `@Widen` on a member LWJGL 3 already declares: keep LWJGL 3's member, only widen its access.
  - `@Hidden`: emit as synthetic, so LWJGL 2 binaries link to it but javac does not see it (prevents overload hijacking
    of LWJGL 3 source).
  - Nested classes in inject classes are not supported yet.

When LWJGL 2 and LWJGL 3 behave differently for the same signature, LWJGL 3 wins.

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
