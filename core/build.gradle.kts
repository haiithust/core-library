plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK)

    defaultConfig {
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }

    androidExtensions {
        isExperimental = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }

    resourcePrefix("core_")
}

dependencies {
    api(platform(project(":depconstraints")))
    kapt(platform(project(":depconstraints")))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.KOTLIN_STDLIB)
    api("com.jakewharton.timber:timber:4.7.1")

    api(Libs.ACTIVITY_KTX)
    api(Libs.FRAGMENT_KTX)
    api(Libs.CONSTRAINT_LAYOUT)
    api(Libs.MATERIAL)
    api(Libs.APPCOMPAT)

    api(Libs.COROUTINES)
    api(Libs.CORE_KTX)
    api(Libs.LIFECYCLE_VIEW_MODEL_KTX)
    api(Libs.LIFECYCLE_LIVE_DATA_KTX)

    implementation(Libs.HILT_ANDROID)
    kapt(Libs.HILT_COMPILER)
}
repositories {
    mavenCentral()
}
