plugins {
    java
    application
    kotlin("jvm") version "1.9.0"
    id("org.openjfx.javafxplugin").version("0.0.13")

    kotlin("plugin.lombok") version "1.9.10"
    id("io.freefair.lombok") version "8.1.0"

}

group = "edu.austral.dissis.chess"
version = "2.0.1"

repositories {
//    mavenLocal()
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/austral-ingsis/chess-ui")
        credentials {
            username = project.properties["github.user"] as String
            password = project.properties["github.token"] as String
        }
    }
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("edu.austral.dissis.chess:chess-ui:2.0.1")
    implementation ("edu.austral.dissis.chess:simple-client-server:1.2.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.8.10")

}

tasks.test {
    useJUnitPlatform()
}

javafx {
    version = "18"
    modules = listOf("javafx.graphics")
}

application {
    // Define the main class for the application.
    mainClass.set("edu.austral.dissis.chess.AppKt")
}
