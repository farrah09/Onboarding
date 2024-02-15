buildscript{
    repositories{
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies{
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.50")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.21")
        classpath ("org.jlleitschuh.gradle:ktlint-gradle:11.6.1")
    }

}