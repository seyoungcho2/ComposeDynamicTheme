apply {
    plugin("io.github.gradle-nexus.publish-plugin")
}

plugins {
    id("com.android.application").version(ProjectVersions.application).apply(false)
    id("com.android.library").version(ProjectVersions.library).apply(false)
    id("org.jetbrains.kotlin.android").version(ProjectVersions.kotlinAndroid).apply(false)
}

buildscript {
    dependencies {
        this.classpath("io.github.gradle-nexus:publish-plugin:1.1.0")
    }
}

apply {
    this.from("${rootDir}/scripts/publish-root.gradle")
    this.from("${rootDir}/scripts/publish.gradle")
}