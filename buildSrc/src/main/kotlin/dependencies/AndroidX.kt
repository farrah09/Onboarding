package dependencies

import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

object AndroidX {
    private const val coreKtxVersion = "1.12.0"
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    private const val lifecycleKtxVersion = "2.7.0"
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleKtxVersion"
    private const val appCompatVersion = "1.6.1"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
}

fun DependencyHandler.ktx(){
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.lifecycleKtx)
    implementation(AndroidX.appCompat)
}