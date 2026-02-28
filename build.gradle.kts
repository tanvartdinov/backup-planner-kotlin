plugins {
    kotlin("jvm") version "2.3.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("app.MainKt")
}

tasks.test {
    useJUnitPlatform()
}