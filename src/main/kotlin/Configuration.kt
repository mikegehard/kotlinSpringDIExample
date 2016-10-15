package demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = arrayOf("demo"))
open class Configuration {
    @Bean
    open fun connection(): DatabaseConnection = MySqlConnection()
}
