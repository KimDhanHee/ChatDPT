import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
  kotlin("kapt")
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("com.google.dagger.hilt.android")
}

android {
  namespace = "dany.tothemoon.core.network"
  compileSdk = 33

  defaultConfig {
    buildConfigField(
      type = "String",
      name = "OPEN_API_KEY",
      value = gradleLocalProperties(rootDir).getProperty("open_api_key")
    )
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  implementation(libs.retrofit.core)
  implementation(libs.retrofit.kotlinx.serialization)

  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)
}