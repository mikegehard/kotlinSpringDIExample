package demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.stereotype.Component


fun main(args: Array<String>) {
    val context: ApplicationContext = AnnotationConfigApplicationContext(Configuration::class.java)

    val action: SaveUser = context.getBean(SaveUser::class.java)

    action.execute()
}

@Component
class SaveUser(@Autowired val dbConnection: DatabaseConnection) {
    fun execute() {
        dbConnection.execute("insert into users")
    }
}

interface DatabaseConnection {
    fun execute(sql: String)
}

class MySqlConnection() : DatabaseConnection {
    override fun execute(sql: String) {
        println("Executing $sql against MySQL")
    }

}

class PostgresConnection() : DatabaseConnection {
    override fun execute(sql: String) {
        println("Executing $sql against Postgres")
    }

}
