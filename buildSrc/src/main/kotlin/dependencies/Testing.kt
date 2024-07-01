package dependencies

import androidTestImplementation
import debugImplementation
import org.gradle.api.artifacts.dsl.DependencyHandler
import testImplementation
import testRuntimeOnly

object Testing {
    private const val junitVersion = "4.13.2"
    const val junit4 = "junit:junit:$junitVersion"

    private const val junitAndroidExtVersion = "1.1.5"
    const val junitAndroidExt = "androidx.test.ext:junit:$junitAndroidExtVersion"

    private const val espressoCoreVersion = "3.5.1"
    const val espressoCore = "androidx.test.espresso:espresso-core:$espressoCoreVersion"

    const val junitComposeUiTest = "androidx.compose.ui:ui-test-junit4"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiTest = "androidx.compose.ui:ui-test-manifest"

    const val junitJupiterApi = "org.junit.jupiter:junit-jupiter:$junitVersion"
    const val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine:$junitVersion"

    private const val androidArchCoreTestingVersion = "2.2.0"
    const val androidArchCoreTesting = "androidx.arch.core:core-testing:$androidArchCoreTestingVersion"

    private const val kluentAndroidVersion = "1.73"
    const val kluentAndroid = "org.amshove.kluent:kluent-android:$kluentAndroidVersion"

    private const val navigationTestVersion = "2.7.7"
    const val navigationTest = "androidx.navigation:navigation-testing:$navigationTestVersion"

    private const val coroutinesTestVersion = "1.5.1"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesTestVersion"

    private const val mockkVersion = "1.13.9"
    const val mockk = "io.mockk:mockk:$mockkVersion"
    const val mockkAndroid = "io.mockk:mockk-android:$mockkVersion"

    private const val mockitoCoreVersion = "1.10.19"
    const val mockitoCore = "org.mockito:mockito-core:$mockitoCoreVersion"

    const val hiltTesting = "com.google.dagger:hilt-android-testing:${DaggerHilt.version}"

    private const val testRunnerVersion = "1.4.0"
    const val testRunner = "androidx.test:runner:$testRunnerVersion"

    private const val annotationVersion = "1.1.0"
    const val annotation = "androidx.annotation:annotation:$annotationVersion"

    private const val androidTestCoreVersion = "1.4.0"
    const val androidTestCore = "androidx.test:core:$androidTestCoreVersion"

    private const val kotlinTestVersion = "1.5.21"
    const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:$kotlinTestVersion"
}

fun DependencyHandler.test() {
    testImplementation(Testing.junit4)
    testImplementation(Testing.junitJupiterApi)
    testRuntimeOnly(Testing.junitJupiterEngine)
    testImplementation(Testing.androidArchCoreTesting)
    testImplementation(Testing.kluentAndroid)
    testImplementation(Testing.androidTestCore)
    testImplementation(Testing.kotlinTest)
    testImplementation(Testing.mockitoCore)
    testImplementation(Testing.mockk)
    androidTestImplementation(Testing.junitAndroidExt)
    androidTestImplementation(Testing.espressoCore)
    androidTestImplementation(platform(Compose.bom))
    androidTestImplementation(Testing.junitComposeUiTest)
    androidTestImplementation(Testing.hiltTesting)
    androidTestImplementation(Testing.testRunner)
    androidTestImplementation(Testing.mockkAndroid)
    androidTestImplementation(Testing.annotation)
    debugImplementation(Testing.composeUiTest)
    debugImplementation(Testing.composeUiTooling)
    debugImplementation(Testing.navigationTest)
}
