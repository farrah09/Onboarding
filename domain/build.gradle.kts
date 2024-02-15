import dependencies.compose
import dependencies.core
import dependencies.hilt

plugins {
    `android-library`
    `kotlin-android`
}

apply<GradlePlugins>()

android {
    namespace = "com.fandroid.domain"
}

dependencies {

    core()

    coroutines()
    hilt()
    compose()
}
