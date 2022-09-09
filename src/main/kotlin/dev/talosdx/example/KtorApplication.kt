package dev.talosdx.example

import com.typesafe.config.ConfigFactory
import dev.talosdx.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import mu.KotlinLogging

private val logger = KotlinLogging.logger("ktor.application")
fun main() {
    embeddedServer(Netty, environment = applicationEngineEnvironment {
        log = logger
        config = HoconApplicationConfig(ConfigFactory.load())

        module {
            configureKoin()
            configureSecurity()
            configureSerialization()
            configureHTTP()
            configureMonitoring()
            configureRouting()
        }

        connector {
            host = config.host
            port = config.port
        }
    }).start(true)
}


//EngineMain variant
//fun main(args: Array<String>) = EngineMain.main(args)
//
//
//fun Application.appRunner() {
//    module {
//        configureSecurity()
//        configureSerialization()
//        configureHTTP()
//        configureMonitoring()
//        configureRouting()
//    }
//}