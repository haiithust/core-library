plugins {
    id("java-platform")
    id("maven-publish")
}

val appcompat = "1.2.0"
val activity = "1.1.0"
val constraintLayout = "2.0.2"
val core = "1.3.2"
val coroutines = "1.3.9"
val crashlytics = "17.2.1"
val analytics = "17.6.0"
val fragment = "1.2.5"
val glide = "4.11.0"
val gson = "2.8.6"
val hilt = Versions.HILT
val hiltJetPack = "1.0.0-alpha01"
val lifecycle = "2.2.0"
val material = "1.2.1"
val okhttp = "3.10.0"
val room = "2.2.5"
val exoplayer = "2.12.0"
val workmanager = "2.4.0"
val intro = "6.0.0"

dependencies {
    constraints {
        api("${Libs.ACTIVITY_KTX}:$activity")
        api("${Libs.ANDROIDX_HILT_COMPILER}:$hiltJetPack")
        api("${Libs.APPCOMPAT}:$appcompat")
        api("${Libs.CONSTRAINT_LAYOUT}:$constraintLayout")
        api("${Libs.CORE_KTX}:$core")
        api("${Libs.COROUTINES}:$coroutines")
        api("${Libs.CRASHLYTICS}:$crashlytics")
        api("${Libs.ANALYTICS}:$analytics")
        api("${Libs.FRAGMENT_KTX}:$fragment")
        api("${Libs.GLIDE}:$glide")
        api("${Libs.GLIDE_COMPILER}:$glide")
        api("${Libs.GSON}:$gson")
        api("${Libs.HILT_ANDROID}:$hilt")
        api("${Libs.HILT_COMPILER}:$hilt")
        api("${Libs.HILT_VIEWMODEL}:$hiltJetPack")
        api("${Libs.HILT_WORKER}:$hiltJetPack")
        api("${Libs.KOTLIN_STDLIB}:${Versions.KOTLIN}")
        api("${Libs.LIFECYCLE_LIVE_DATA_KTX}:$lifecycle")
        api("${Libs.LIFECYCLE_VIEW_MODEL_KTX}:$lifecycle")
        api("${Libs.LIFECYCLE_SERVICE}:$lifecycle")
        api("${Libs.LIFECYCLE_PROCESS}:$lifecycle")
        api("${Libs.MATERIAL}:$material")
        api("${Libs.NAVIGATION_FRAGMENT_KTX}:${Versions.NAVIGATION}")
        api("${Libs.NAVIGATION_UI_KTX}:${Versions.NAVIGATION}")
        api("${Libs.ROOM_KTX}:$room")
        api("${Libs.ROOM_RUNTIME}:$room")
        api("${Libs.ROOM_COMPILER}:$room")
        api("${Libs.OKHTTP}:$okhttp")
        api("${Libs.OKHTTP_LOGGING_INTERCEPTOR}:$okhttp")
        api("${Libs.EXOPLAYER_CORE}:$exoplayer")
        api("${Libs.EXOPLAYER_UI}:$exoplayer")
        api("${Libs.WORK_MANAGER}:$workmanager")
        api("${Libs.WORK_MANAGER}:$workmanager")
        api("${Libs.INTRO}:$intro")
    }
}

publishing {
    publications {
        create<MavenPublication>("myPlatform") {
            from(components["javaPlatform"])
        }
    }
}
