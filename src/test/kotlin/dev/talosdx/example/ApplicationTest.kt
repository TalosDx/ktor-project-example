package dev.talosdx.example

import dev.talosdx.example.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ApplicationTest {
//    @JvmField
//    @RegisterExtension
//    val koinTestExtension = KoinTestExtension.create {
//        slf4jLogger()
//        modules(testAppModule())
//    }

    @Test
    fun contextIsCreatedForTheTest() {
//        assertNotNull(get<TestComponent>())
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