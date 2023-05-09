import version.LibraryVersions

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.github.seyoungcho2.dynamictheme"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = LibraryVersions.composeComplier
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

apply {
    from("${rootDir}/scripts/publish-module.gradle")
}

dependencies {
    implementation("androidx.core:core-ktx:${LibraryVersions.androidCore}")
    implementation("androidx.appcompat:appcompat:${LibraryVersions.appCompat}")

    // Compose Support
    val composeBom = platform("androidx.compose:compose-bom:${LibraryVersions.composeBom}")
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.ui:ui")

    // Compose Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Data Store
    implementation("androidx.datastore:datastore-preferences:${LibraryVersions.datastorePreference}")

    // Test
    testImplementation("junit:junit:${LibraryVersions.junit}")
    androidTestImplementation("androidx.test.ext:junit:${LibraryVersions.androidJUnit}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${LibraryVersions.espresso}")
}