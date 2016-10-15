package demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class Configuration {
    @Bean
    open fun action(): SaveUser = SaveUser(connection())

    fun connection(): DatabaseConnection = MySqlConnection()
}
