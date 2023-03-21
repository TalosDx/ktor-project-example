package dev.talosdx.example.configuration

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

data class DatabaseConfiguration(
    val url: String,
    val username: String,
    val password: String,
)