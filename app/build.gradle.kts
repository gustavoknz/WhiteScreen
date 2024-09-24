plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.hilt)
    id("kotlin-kapt")
}

private val release = "release"

android {
    namespace = "com.kieling.whitescreen"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.kieling.whitescreen"
        minSdk = 26
        targetSdk = 35
        versionCode = 9
        versionName = "2.2.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables { useSupportLibrary = true }
        tasks.withType<Test> { useJUnitPlatform() }
    }

    signingConfigs {
        create(release) {
            storeFile = file("C:\\Users\\Gustavo\\Dropbox\\AndroidKeys\\whiteScreen.jks")
            storePassword = "wh1t35cr33n"
            keyAlias = "upload"
            keyPassword = "wh1t35cr33n"
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kapt { correctErrorTypes = true }
    kotlinOptions { jvmTarget = "17" }
    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = "1.5.15" }
    packaging {
        resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" }
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(platform(libs.androidx.compose.bom))

    // Hilt
    implementation(libs.google.hilt)
    kapt(libs.google.hilt.compiler)

    testImplementation(libs.jupiter)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
