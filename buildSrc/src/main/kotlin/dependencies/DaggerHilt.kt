package dependencies

import implementation
import kapt
import org.gradle.api.artifacts.dsl.DependencyHandler

object DaggerHilt {
    const val version = "2.50"
    const val hiltAndroid = "com.google.dagger:hilt-android:$version"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"
}

fun DependencyHandler.hilt(){
    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltCompiler)
}