import org.gradle.api.artifacts.dsl.DependencyHandler

object Coroutines {
    const val version = "1.8.0-RC2"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
}
fun DependencyHandler.coroutines(){
    implementation(Coroutines.coroutines)
}