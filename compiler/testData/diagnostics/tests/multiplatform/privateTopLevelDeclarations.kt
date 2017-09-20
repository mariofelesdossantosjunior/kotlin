// !LANGUAGE: +MultiPlatformProjects
// MODULE: m1-common
// FILE: common.kt

<!PRIVATE_EXPECTED_DECLARATION, JVM:PRIVATE_EXPECTED_DECLARATION!>private<!> expect fun foo()
<!PRIVATE_EXPECTED_DECLARATION, JVM:PRIVATE_EXPECTED_DECLARATION!>private<!> expect val bar: String
<!PRIVATE_EXPECTED_DECLARATION, JVM:PRIVATE_EXPECTED_DECLARATION!>private<!> expect fun Int.memExt(): Any

<!PRIVATE_EXPECTED_DECLARATION, JVM:PRIVATE_EXPECTED_DECLARATION!>private<!> expect class Foo

// MODULE: m2-jvm(m1-common)
// FILE: jvm.kt

private actual fun foo() {}
private actual val bar: String = ""
private actual fun Int.memExt(): Any = 0

private actual class Foo
