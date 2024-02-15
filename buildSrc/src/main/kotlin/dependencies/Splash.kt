package dependencies

import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

object Splash {
    private const val splashScreenVersion = "1.0.0-beta02"
    const val splashScreen = "androidx.core:core-splashscreen:$splashScreenVersion"
}

fun DependencyHandler.splashScreen(){
    implementation(Splash.splashScreen)
}