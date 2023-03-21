package dev.talosdx.example

import dev.talosdx.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import mu.KotlinLogging
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.ktor.ext.get
import org.koin.ktor.ext.inject

private val logger = KotlinLogging.logger("ktor.application")
fun main() {
    embeddedServer(Netty, environment = applicationEngineEnvironment {
        log = logger

        module {
            loadConfigsConfigKoin()

            //set up app config
            config = get()

            configureSecurity()
            configureSerialization()
            configureHTTP()
            configureMonitoring()
            configureRouting()

            val database by inject<Database>()
            transaction(database) {

            }
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