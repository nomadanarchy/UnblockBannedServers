plugins {
    id("dev.kikugie.stonecutter")
}

stonecutter active "1.20.5"

tasks.register("chiseledBuild") {
    group = "project"
    dependsOn(stonecutter.tasks.named("build"))
}
