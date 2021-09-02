import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "me.tobiasliese.jackson_reproducer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("me.tobiasliese.jackson_reproducer.Main")
    mainClassName = "me.tobiasliese.jackson_reproducer.Main" // required for gluon
}

gluonfx {
    isVerbose = true
    compilerArgs.add("-H:+AllowIncompleteClasspath")
}

plugins {
    idea
    application
    id("org.openjfx.javafxplugin") version "0.0.10"
    id("com.gluonhq.gluonfx-gradle-plugin") version "1.0.4"
    kotlin("jvm") version "1.5.30"
    //
}

apply(plugin = "idea")

idea {
    module {
        inheritOutputDirs = true
    }
}

javafx {
    modules("javafx.controls", "javafx.fxml", "javafx.graphics")
}

dependencies {
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.12.4")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.4")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.4")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.30")
    implementation(kotlin("stdlib-jdk8"))
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "11"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "11"
}