package dev.talosdx.example.plugins

import dev.talosdx.example.MainAppModule
import io.ktor.server.application.*
import org.koin.ksp.generated.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.loadConfigsConfigKoin() {
    //Install koin
    install(Koin) {
        slf4jLogger()
        modules(MainAppModule().module)

    }
}