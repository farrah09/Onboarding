import dependencies.compose
import dependencies.hilt
import dependencies.test

plugins {
    `android-library`
    `kotlin-android`
}

apply<GradlePlugins>()

android {
    namespace = "com.fandroid.core"
}

dependencies {
    hilt()
    compose()
    test()
}
