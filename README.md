# Template for creating a server application in Kotlin
Tired of building and configuring dependencies from scratch each time. Therefore, I created this repository, simply by reusing it, albeit with extra dependencies, I will get what I need without spending extra 2-4 hours on configuration.

# What inside?
- [x] Ktor
- [x] Koin (DI with annotations like Spring)
- [ ] Koin Test (wait support Kotlin 1.8.10)
- [x] JUnit5
- [ ] TestContainers (in progress...)
- [x] Kotlin Logging 
  - [x] Frontend: SLF4j Api
  - [x] Backend: Logback (default configs in progress..)
- [ ] Exposed (default configs & tests in progress...)
  - [x] Postgres JDBC
- [x] Gradle Kotlin DSL
- [x] Dockerfile
- [x] Docker Compose (build & run, required test)
