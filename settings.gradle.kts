pluginManagement {
    repositories {
        google {
            jcenter()
            maven ("https://jitpack.io" )
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")

            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        jcenter()
        maven ("https://jitpack.io" )
        mavenCentral()

    }
}

rootProject.name = "Scratch Card"
include(":app")
 