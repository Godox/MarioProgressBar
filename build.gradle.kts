import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.intellij") version "1.14.1"
    id("org.jetbrains.kotlin.jvm") version "1.8.21"
    id("java")
}

group = "manjaro.mpb"
version = "1.7"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.squareup:gifencoder:0.10.1")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2022.1")
    plugins.set(listOf("java"))
    updateSinceUntilBuild.set(false)
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "11"
    }
}