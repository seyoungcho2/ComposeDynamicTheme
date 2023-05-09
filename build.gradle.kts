plugins {
    id("com.android.application").version(ProjectVersions.application).apply(false)
    id("com.android.library").version(ProjectVersions.library).apply(false)
    id("org.jetbrains.kotlin.android").version(ProjectVersions.kotlinAndroid).apply(false)
    id("io.github.gradle-nexus.publish-plugin").version("1.1.0")
}

buildscript {
    dependencies {
        this.classpath("io.github.gradle-nexus:publish-plugin:1.1.0")
    }
}

apply {
    this.from("scripts/publish-root.gradle")
}