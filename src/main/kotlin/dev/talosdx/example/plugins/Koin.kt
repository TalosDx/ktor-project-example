package dev.talosdx.example.plugins

import dev.talosdx.example.modules.mainAppModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    //Install koin
    install(Koin) {
        slf4jLogger()
        modules(mainAppModule())
    }
}