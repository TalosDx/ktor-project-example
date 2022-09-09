package dev.talosdx.example.modules

import dev.talosdx.example.stub.TestComponent
import org.koin.dsl.module

fun testAppModule() = module {
    single { TestComponent() }
}