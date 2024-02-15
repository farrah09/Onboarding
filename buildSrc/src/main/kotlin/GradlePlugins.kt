import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class GradlePlugins: Plugin<Project> {
    override fun apply(project: Project) {
        applyPlugins(project)
        setProjectConfig(project)
    }

    private fun applyPlugins(project: Project){
        project.apply{
            plugin("android-library")
            plugin("kotlin-android")
            plugin("com.google.dagger.hilt.android")
            plugin("kotlin-kapt")
            plugin("org.jlleitschuh.gradle.ktlint")
        }
    }



    private fun setProjectConfig(project: Project){
        project.android().apply {
            compileSdk = ProjectConfig.compileSdk

            defaultConfig {
                minSdk = ProjectConfig.minSdk
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                vectorDrawables {
                    useSupportLibrary = true
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }

            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = "1.5.7"
            }
            packaging {
                resources {
                    excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    excludes += "META-INF/gradle/incremental.annotation.processors"
                    excludes += "META-INF/DEPENDENCIES"
                    excludes += "META-INF/LICENSE"
                    excludes += "META-INF/LICENSE.txt"
                    excludes += "META-INF/license.txt"
                    excludes += "META-INF/NOTICE"
                    excludes += "META-INF/NOTICE.txt"
                    excludes += "META-INF/notice.txt"
                    excludes += "META-INF/ASL2.0"
                    excludes += "META-INF/*.kotlin_module"
                }
            }

        }

    }



    private fun Project.android():LibraryExtension{
        return extensions.getByType(LibraryExtension::class.java)
    }
}
