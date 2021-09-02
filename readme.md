# Bug reproducer for Jackson

works like expected: (prints yaml string content in stdout)

```shell
.\gradlew run
```

To reproduce:

```shell
.\gradlew clean
.\gradlew nativeRunAgent # close window
.\gradlew nativeBuild
.\gradlew nativeRun
```

Tested on Windows 10 with graalvm 21.2.0 with java 11