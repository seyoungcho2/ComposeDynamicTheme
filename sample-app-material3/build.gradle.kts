import version.LibraryVersions

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "io.github.seyoungcho2.dynamicthemesample.material3"
    compileSdk = 33

    defaultConfig {
        applicationId = "io.github.seyoungcho2.dynamicthemesample.material3"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":dynamic-theme-m3"))

    implementation("androidx.core:core-ktx:${LibraryVersions.androidCore}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${LibraryVersions.lifecycleRuntime}")
    implementation("androidx.activity:activity-compose:${LibraryVersions.activityCompose}")

    // Compose
    val composeBom = platform("androidx.compose:compose-bom:${LibraryVersions.composeBom}")
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Test
    testImplementation("junit:junit:${LibraryVersions.junit}")
    androidTestImplementation("androidx.test.ext:junit:${LibraryVersions.androidJUnit}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${LibraryVersions.espresso}")
}