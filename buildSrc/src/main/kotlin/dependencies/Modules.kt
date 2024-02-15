package dependencies

import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Modules {
    const val app = ":app"

    const val core = ":core"
    const val coreUi = ":core-ui"

    const val data = ":data"
    const val domain = ":domain"

    const val onboarding = ":features:onboarding"

    const val main = ":features:main"
}

fun DependencyHandler.core()  {
    implementation(project(Modules.core))
}

fun DependencyHandler.coreUi()  {
    implementation(project(Modules.coreUi))
}
fun DependencyHandler.data()  {
    implementation(project(Modules.data))
}

fun DependencyHandler.domain()  {
    implementation(project(Modules.domain))
}

fun DependencyHandler.onboarding()  {
    implementation(project(Modules.onboarding))
}

fun DependencyHandler.main()  {
    implementation(project(Modules.main))
}
