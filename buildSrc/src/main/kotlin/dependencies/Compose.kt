package dependencies

import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

object Compose {
    const val composeVersion = "1.1.0-rc01"
    const val composeCompilerVersion = "1.1.0-rc02"

    private const val activityComposeVersion = "1.8.2"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
    const val material = "androidx.compose.material3:material3"
    const val ui = "androidx.compose.ui:ui"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val bom = "androidx.compose:compose-bom:2023.08.00"

    const val runtime = "androidx.compose.runtime:runtime:$composeVersion"
    const val compiler = "androidx.compose.compiler:compiler:$composeCompilerVersion"

    private const val navigationVersion = "2.7.0-rc01"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    private const val hiltNavigationComposeVersion = "1.0.0"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    private const val lifecycleVersion = "2.4.0"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
}

fun DependencyHandler.compose(){
    implementation(Compose.activityCompose)
    implementation(Compose.material)
    implementation(Compose.ui)
    implementation(Compose.uiToolingPreview)
    implementation(Compose.activityCompose)
    implementation(Compose.hiltNavigationCompose)
    implementation(Compose.navigation)
    implementation(Compose.viewModelCompose)
    implementation(platform(Compose.bom))
}
