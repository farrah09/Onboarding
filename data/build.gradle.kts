import dependencies.compose
import dependencies.core
import dependencies.domain
import dependencies.hilt
import dependencies.test

plugins {
    `android-library`
    `kotlin-android`
}

apply<GradlePlugins>()

android {
    namespace = "com.fandroid.main_data"
}

dependencies {

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    core()
    room()
    hilt()
    compose()
    domain()
    test()
}
