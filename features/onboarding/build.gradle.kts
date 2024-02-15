import dependencies.compose
import dependencies.core
import dependencies.coreUi
import dependencies.domain
import dependencies.hilt
import dependencies.test

plugins {
    `android-library`
    `kotlin-android`
}

apply<GradlePlugins>()

android {
    namespace = "com.fandroid.onboarding"
}

dependencies {

    coreUi()
    core()
    domain()

    hilt()
    compose()
    test()
}
