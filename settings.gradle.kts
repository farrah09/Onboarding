pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "OnboardingApp"
include(":app")
include(":core")
include(":core-ui")
include(":data")
include(":domain")
include(":features")
include(":features:onboarding")
include(":features:main")
