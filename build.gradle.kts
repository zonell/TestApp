buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")

    }
}
plugins {
    id("com.android.application") version "8.1.4" apply false
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
    id("androidx.room") version "2.6.1" apply false
    id("com.google.devtools.ksp") version "1.9.23-1.0.19" apply false
    id("com.android.library") version "8.1.4" apply false
}