plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.andrux.andluax"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.andrux.andluax"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "0.1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17

        // language-textmate 在 Android 13(API 33) 以下运行时，官方建议开启 desugaring
        // 参考: https://project-sora.github.io/sora-editor-docs/guide/getting-started
        isCoreLibraryDesugaringEnabled = true
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2024.06.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.activity:activity-compose:1.9.1")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // sora-editor (Sora Code Editor) + TextMate
    // 参考: https://project-sora.github.io/sora-editor-docs/guide/getting-started
    implementation(platform("io.github.rosemoe:editor-bom:0.24.4"))
    implementation("io.github.rosemoe:editor")
    implementation("io.github.rosemoe:language-textmate")

    // Core Library Desugaring（TextMate 在 API < 33 推荐开启）
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.1.5")
}

