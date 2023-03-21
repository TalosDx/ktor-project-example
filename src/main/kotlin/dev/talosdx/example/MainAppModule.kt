package dev.talosdx.example

import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.config.*
import org.jetbrains.exposed.sql.Database
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import javax.sql.DataSource

@Module
@ComponentScan
class MainAppModule {
    @Single
    fun appConfig() : ApplicationConfig =
        HoconApplicationConfig(ConfigFactory.load())

    @Single
    fun configureHikari(appConfig: ApplicationConfig): HikariConfig {
        val config = HikariConfig()
        config.jdbcUrl = appConfig["database.url"]
        config.username = appConfig["database.username"]
        config.password = appConfig["database.password"]
        return config
    }
    @Single
    fun configureDataSource(config: HikariConfig): DataSource =
        HikariDataSource(config)

    @Single
    fun configureDatabase(config: DataSource) =
        Database.connect(config)
}

private operator fun ApplicationConfig.get(key: String): String {
    return property(key).getString()
}