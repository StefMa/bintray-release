import guru.stefma.bintrayrelease.PublishExtension

plugins {
    kotlin("jvm") version "1.3.21"
    `java-gradle-plugin`
    id("guru.stefma.bintrayrelease") version "1.1.1" 
}

repositories {
    google()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")
    implementation("guru.stefma.androidartifacts:androidartifacts:1.2.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.3.1")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.3.1")
    testImplementation("org.assertj:assertj-core:3.11.1")
}

tasks.withType(Test::class.java) {
    useJUnitPlatform()
}

gradlePlugin {
    plugins {
        create("binrayRelease") {
            id = "guru.stefma.bintrayrelease"
            implementationClass = "guru.stefma.bintrayrelease.BintrayReleasePlugin"
        }
    }
}

version = "1.1.1"
group = "guru.stefma.bintrayrelease"
javaArtifact { 
    artifactId = "bintrayrelease"
}

publish {
    userOrg = "stefma"
    uploadName = "BintrayRelease"
    desc = "Super duper easy way to release your Android and other artifacts to bintray"
    website = "https://github.com/StefMa/bintray-release"
}
