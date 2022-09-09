package dev.talosdx.example

import dev.talosdx.example.modules.testAppModule
import dev.talosdx.example.plugins.configureRouting
import dev.talosdx.example.stub.TestComponent
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import org.koin.logger.slf4jLogger
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.junit5.KoinTestExtension

class ApplicationTest : KoinTest {
    @JvmField
    @RegisterExtension
    val koinTestExtension = KoinTestExtension.create {
        slf4jLogger()
        modules(testAppModule())
    }

    @Test
    fun contextIsCreatedForTheTest() {
        assertNotNull(get<TestComponent>())
    }

    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
}