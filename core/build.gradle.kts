plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.github.dcendents.android-maven")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            consumerProguardFiles("proguard-rules.pro")
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
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.10")
    api("com.jakewharton.timber:timber:4.7.1")

    api("androidx.activity:activity-ktx:1.1.0")
    api("androidx.fragment:fragment-ktx:1.2.5")
    api("androidx.constraintlayout:constraintlayout:2.0.4")
    api("com.google.android.material:material:1.2.1")
    api("androidx.appcompat:appcompat:1.2.0")

    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    api("androidx.core:core-ktx:1.3.2")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    api("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")

    implementation("com.google.dagger:hilt-android:2.28-alpha")
    kapt("com.google.dagger:hilt-android-compiler:2.28-alpha")
}
repositories {
    mavenCentral()
}
