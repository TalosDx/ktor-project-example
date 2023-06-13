//program language
val kotlinVersion = "1.8.21"
val coroutinesVersion = "1.7.1"

//framework
val ktorVersion = "2.3.1"

//di
val koinVersion = "3.4.2"
val koinTestVersion = "3.4.1"
val koinKtorVersion = "3.4.1"
val koinSlf4jVersion = "3.4.1"
val koinAnnotationsVersion = "1.2.2"

//test
val junitVersion = "5.9.3"

//logs
val slf4jApiVersion = "2.0.7"
val kotlinLoggingJvm = "3.0.5"
val logbackVersion = "1.4.6"

//dao
val exposedVersion = "0.41.1"
val hikariVersion = "5.0.1"
val postgresVersion = "42.6.0"

plugins {
    application
    kotlin("jvm") version "1.8.21"
    id("io.ktor.plugin") version "2.3.1"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"
    id("com.google.devtools.ksp") version "1.8.21-1.0.11"
}

group = "dev.talosdx"
version = "0.0.1"

application {
    mainClass.set("dev.talosdx.example.KtorApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}
repositories {
    mavenCentral()
}


// Use KSP Generated sources
sourceSets.main {
    java.srcDirs("build/generated/ksp/main/kotlin")
}

dependencies {
    // Program Language
    implementation(kotlin("stdlib-jdk8"))

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")

    // Koin for Kotlin apps
    implementation("io.insert-koin:koin-core:$koinVersion")
    implementation("io.insert-koin:koin-logger-slf4j:$koinSlf4jVersion")
    implementation("io.insert-koin:koin-annotations:$koinAnnotationsVersion")
    ksp("io.insert-koin:koin-ksp-compiler:$koinAnnotationsVersion")

    // Framework
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-auth-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-sessions-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-auto-head-response-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-double-receive-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-resources-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-host-common-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-status-pages-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-compression-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-caching-headers-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-conditional-headers-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-default-headers-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-forwarded-header-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-http-redirect-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-partial-content-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-call-logging-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-call-id-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
    implementation("io.insert-koin:koin-ktor:$koinKtorVersion")

    // Logger
    implementation("org.slf4j:slf4j-api:$slf4jApiVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("io.github.microutils:kotlin-logging-jvm:$kotlinLoggingJvm")


    // DAO & Database
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposedVersion")
    implementation("org.postgresql:postgresql:$postgresVersion")
    implementation("com.zaxxer:HikariCP:$hikariVersion")

    // Testing
//    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-debug:$coroutinesVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")

     testImplementation("io.insert-koin:koin-test:$koinTestVersion")
     testImplementation("io.insert-koin:koin-test-junit5:$koinTestVersion")

    testImplementation("io.ktor:ktor-server-test-host:$ktorVersion") {
        exclude("org.jetbrains.kotlin", "kotlin-test-junit")
    }
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktorVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}