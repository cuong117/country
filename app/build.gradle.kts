import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

val key = "tSmbZ0bbHnXefc37"
val iv = "YUtlpkLt5Tr9Ppoo"

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ksp)
    id(libs.plugins.parcelize.get().pluginId)
}

android {
    namespace = "com.myapp.country"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.myapp.country"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        val url = project.property("base_url") as String
        buildConfigField("String", "BASE_URL", "\"${encrypt(url, key, iv)}\"")
        val test = project.property("test") as String
        buildConfigField("String", "TEST", "\"${encrypt(test, key, iv)}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.retrofit)
    implementation(libs.coroutines)
    implementation(libs.koin)
    implementation(libs.logging.interceptor)
    implementation(libs.converter.gson)
    implementation(libs.glide)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    implementation(libs.gson)
    ksp(libs.room.compiler)
    implementation(libs.splashscreen)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

fun encrypt(input: String, key: String, iv: String): String {

    val ivParameterSpec = IvParameterSpec(iv.toByteArray())
    val secretKeySpec = SecretKeySpec(key.toByteArray(), "AES")
    val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec)
    val encrypted = cipher.doFinal(input.toByteArray())
    return Base64.getEncoder().encodeToString(encrypted)
}