plugins {
    kotlin("multiplatform")
}

group = "fi.papinkivi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    js {
        binaries.executable()
        browser()
    }
    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
