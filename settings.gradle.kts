pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/")
        maven("https://maven.kikugie.dev/releases")
        gradlePluginPortal()
    }
}

plugins {
    id("dev.kikugie.stonecutter") version "0.9.8"
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

stonecutter {
    create(rootProject) {
        val yarnLegacy = arrayOf(
            "1.9.4",   // 1.9.4 - 1.12.2
            "1.13.2",  // 1.13 - 1.13.2
            "1.14.3"   // 1.14 - 1.14.3
        )

        val legacy = arrayOf(
            "1.14.4",  // 1.14.4 - 1.16.5  (Java 8)
            "1.17",    // 1.17 - 1.17.1    (Java 16)
            "1.18",    // 1.18 - 1.20.1    (Java 17)
            "1.20.2",  // 1.20.2 - 1.20.4  (Java 17)
            "1.20.5"   // 1.20.5 - 1.21.11 (Java 21)
        )

        // Unobfuscated
        val modern = arrayOf("26.1") // 26.1 - 26.3

        versions(*yarnLegacy).buildscript("yarn-build.gradle.kts")
        versions(*legacy).buildscript("build.gradle.kts")
        versions(*modern).buildscript("modern-build.gradle.kts")
    }
}
