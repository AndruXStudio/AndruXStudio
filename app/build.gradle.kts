
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
    implementation("io.github.Rosemoe.sora-editor:editor:0.23.4")
    implementation("io.github.Rosemoe.sora-editor:language-text:0.23.4")
}
