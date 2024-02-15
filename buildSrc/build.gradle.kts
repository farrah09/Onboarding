plugins{
    `kotlin-dsl`
}

repositories{
    google()
    mavenCentral()
}

dependencies{
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.21")
    implementation("com.android.tools.build:gradle:8.2.1")

    // Required to fix a missing dependency error
    implementation("com.squareup:javapoet:1.13.0")
}

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = JavaVersion.VERSION_17.toString()
}