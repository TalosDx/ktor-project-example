package dev.talosdx

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dev.talosdx.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSecurity()
        configureSerialization()
        configureHTTP()
        configureMonitoring()
        configureRouting()
    }.start(wait = true)
}
