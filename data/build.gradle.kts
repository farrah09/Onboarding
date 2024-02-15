import dependencies.compose
import dependencies.core
import dependencies.domain
import dependencies.hilt

plugins {
    `android-library`
    `kotlin-android`
}

apply<GradlePlugins>()

android {
    namespace = "com.fandroid.main_data"
}

dependencies {

    core()
    room()
    hilt()
    compose()
    domain()
}
