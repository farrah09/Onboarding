import dependencies.compose
import dependencies.hilt
import dependencies.test

plugins {
    `android-library`
    `kotlin-android`
}

apply<GradlePlugins>()

android {
    namespace = "com.fandroid.core_ui"
}

dependencies {
    compose()
    hilt()
    test()

    coroutines()
}
