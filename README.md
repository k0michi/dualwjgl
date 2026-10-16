# lwjgl2w3

**LWJGL 2 *with* 3**: one set of jars that works as both LWJGL 2 and LWJGL 3.

> [!WARNING]
> This project is **experimental**. It describes a goal, not a finished product, and is not ready for real use.

Unofficial; not affiliated with the LWJGL project.

## Goal

LWJGL 2 and LWJGL 3 share package and class names (`org.lwjgl.opengl.GL11`, `org.lwjgl.BufferUtils`, ...) but are not
compatible, so they cannot be on the same classpath: whichever comes first hides the other.

lwjgl2w3 aims to **merge** the two into a single binary distribution:

- programs compiled against **LWJGL 2.9.3** link and run against it, unchanged;
- programs compiled against **LWJGL 3.4.3** link and run against it, unchanged;
- both kinds of program can be loaded together in the same JVM.

It does this by taking the LWJGL 3 jars and adding the LWJGL 2 API to them, implemented on top of LWJGL 3.
Where the two define the same method differently, LWJGL 3's behavior is kept.

## Building

Requires JDK 21 to build; the merged jars themselves target Java 8.

```bash
./gradlew :dist:assemble
```

The merged jars are written to `dist/build/patched/`. Use them in place of the LWJGL 3 jars of the same name, together
with `lwjgl2w3-extra.jar` and the usual LWJGL 3 natives. To run the tests:

```bash
./gradlew check
```

How the project is put together is described in [docs/DEVELOPMENT.md](docs/DEVELOPMENT.md).

## License

lwjgl2w3 is licensed under the [BSD 3-Clause License](LICENSE).

The jars it builds contain LWJGL 3, and parts of its code are derived from LWJGL 2 and LWJGL 3; both are also under
BSD-style licenses. See [NOTICE](NOTICE) for details and the full license texts.
