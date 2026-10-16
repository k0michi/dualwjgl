# lwjgl2w3

**LWJGL 2 *with* 3**: a single set of jars that works as both LWJGL 2 and LWJGL 3.

> [!WARNING]
> lwjgl2w3 is an **experimental** work in progress and is not ready for real use.

lwjgl2w3 is unofficial and not affiliated with the LWJGL project.

## Goal

LWJGL 2 and LWJGL 3 share package and class names (`org.lwjgl.opengl.GL11`, `org.lwjgl.BufferUtils`, ...) but are not
compatible with each other. They cannot share a classpath, because whichever comes first hides the other.

lwjgl2w3 aims to **merge** the two into one binary distribution, so that:

- programs compiled against **LWJGL 2.9.3** link and run against it unchanged,
- programs compiled against **LWJGL 3.4.3** link and run against it unchanged, and
- both kinds of program can run side by side in the same JVM.

To do this, lwjgl2w3 takes the LWJGL 3 jars and adds the LWJGL 2 API to them, implemented on top of LWJGL 3.

Extensions that LWJGL 2 binds but LWJGL 3 has dropped are currently out of scope.

## Building

Building requires JDK 21. The jars it produces run on Java 8 or later.

```bash
./gradlew :dist:assemble
```

The merged jars are written to `dist/build/patched/`. To use them, put them in place of the LWJGL 3 jars of the same
name, and add `lwjgl2w3-extra.jar` along with the usual LWJGL 3 natives. LWJGL 2's `Display` also needs LWJGL 3's
`lwjgl-sdl` module and its natives; on macOS, run the JVM with `-XstartOnFirstThread`.

To run the tests:

```bash
./gradlew check
```

For how the project is put together, see [docs/DEVELOPMENT.md](docs/DEVELOPMENT.md).

## License

lwjgl2w3 is licensed under the [BSD 3-Clause License](LICENSE).

The jars it builds contain LWJGL 3, and parts of its code are derived from LWJGL 2 and LWJGL 3, both of which use
BSD-style licenses. See [NOTICE](NOTICE) for details and the full license texts.
