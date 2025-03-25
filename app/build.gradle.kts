plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "ru.android.hyrulecompendiumanothermvvm"
    compileSdk = 35

    defaultConfig {
        applicationId = "ru.android.hyrulecompendiumanothermvvm"
        minSdk = 26
        targetSdk = 35
        versionCode = 2
        versionName = "1.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField(
            "String",
            "URL_SERVER",
            "https ://botw-compendium.herokuapp.com/api/v2/"
        )
    }

    buildTypes {
        debug {
            isDebuggable = true
            applicationIdSuffix = ".dev"
        }
        release {
            isMinifyEnabled = false
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

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(libs.kotlin.stdlib)
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)

    implementation(libs.koin.android)
    implementation(libs.koin.core)
    implementation(libs.koin.androidx.scope)
    implementation(libs.koin.androidx.viewmodel)

    implementation(libs.navigation.safe.args.gradle.plugin)

    implementation(libs.library)

    implementation(libs.glide)
    implementation(libs.okhttp3.integration)
    implementation(libs.glide.transformations)
    ksp(libs.ksp)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttpprofiler)

    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.extensions)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.common.java8)

    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

}