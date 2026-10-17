# DuaLWJGL

**dual + LWJGL**: a single set of jars that works as both LWJGL 2 and LWJGL 3.

> [!WARNING]
> DuaLWJGL is an **experimental** work in progress and is not ready for real use.

DuaLWJGL is unofficial and not affiliated with the LWJGL project.

## Goal

LWJGL 2 and LWJGL 3 share package and class names (`org.lwjgl.opengl.GL11`, `org.lwjgl.BufferUtils`, ...) but are not
compatible with each other. They cannot share a classpath, because whichever comes first hides the other.

DuaLWJGL aims to **merge** the two into one binary distribution, so that:

- programs compiled against **LWJGL 2.9.3** link and run against it unchanged,
- programs compiled against **LWJGL 3.4.3** link and run against it unchanged, and
- both kinds of program can run side by side in the same JVM.

To do this, DuaLWJGL takes the LWJGL 3 jars and adds the LWJGL 2 API to them, implemented on top of LWJGL 3.

Extensions that LWJGL 2 binds but LWJGL 3 has dropped are currently out of scope.

## Building

Building requires JDK 21. The jars it produces run on Java 8 or later.

```bash
./gradlew :dist:assemble
```

The merged jars are written to `dist/build/patched/`. With LWJGL 3 version `3.4.3` and Git description `<tag>`, the
output includes `dualwjgl-3.4.3-<tag>.jar` (the main module, including classes that have no LWJGL 3 module owner),
`dualwjgl-util-<tag>.jar`, and patched LWJGL 3 modules such as `dualwjgl-opengl-3.4.3-<tag>.jar`. The official LWJGL 3
module split is preserved, with only the `lwjgl` filename prefix changed; the Git description is appended with a
hyphen. The util API is separate. LWJGL 2's `Display` and `Controllers` also need LWJGL 3's `lwjgl-sdl` module and its
natives (JInput is not needed); on macOS, run the JVM with `-XstartOnFirstThread`.
Programs that use LWJGL 2's OpenCL need `-Dorg.lwjgl.opencl.explicitInit=true`: otherwise LWJGL 3 loads OpenCL on its
own and their `CL.create()` throws.

## Using it from Gradle (JitPack)

[JitPack](https://jitpack.io) builds the jars from a tag or commit of this repository. Use the patched modules in place
of LWJGL 3's own class jars (do not also depend on `org.lwjgl:lwjgl`, `org.lwjgl:lwjgl-opengl`, ...), and LWJGL 3's
natives as usual:

```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    def dualwjgl = '<tag or commit>'
    implementation "com.github.k0michi.dualwjgl:dualwjgl-opengl:$dualwjgl" // brings dualwjgl (core) and lwjgl-sdl
    implementation "com.github.k0michi.dualwjgl:dualwjgl-openal:$dualwjgl"
    implementation "com.github.k0michi.dualwjgl:dualwjgl-util:$dualwjgl"   // lwjgl_util

    def lwjgl = '3.4.3'
    def natives = 'natives-macos-arm64' // or natives-windows, natives-linux, ...
    ['lwjgl', 'lwjgl-opengl', 'lwjgl-openal', 'lwjgl-sdl'].each {
        runtimeOnly "org.lwjgl:$it:$lwjgl:$natives"
    }
}
```

The patched modules are `dualwjgl` (core), `dualwjgl-opengl`, `dualwjgl-opengles`, `dualwjgl-openal`, `dualwjgl-opencl`
and `dualwjgl-util`. `jitpack.yml` runs `./gradlew :dist:publishToMavenLocal`.

To run the tests:

```bash
./gradlew check
```

For how the project is put together, see [docs/DEVELOPMENT.md](docs/DEVELOPMENT.md).

## License

DuaLWJGL is licensed under the [BSD 3-Clause License](LICENSE).

The jars it builds contain LWJGL 3, and parts of its code are derived from LWJGL 2 and LWJGL 3, both of which use
BSD-style licenses. See [NOTICE](NOTICE) for details and the full license texts.
