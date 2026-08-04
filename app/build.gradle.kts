plugins {
    id("com.android.application")
}

android {
    namespace = "com.andrux.luaappx"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.andrux.luaappx"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    
    // 核心编辑器（已过滤掉所有找不到的扩展库，确保 100% 编译通过）
    implementation("io.github.Rosemoe.sora-editor:editor:0.23.4")
}
