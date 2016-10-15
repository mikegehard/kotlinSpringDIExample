package demo

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main(args: Array<String>) {
    val context: ApplicationContext = AnnotationConfigApplicationContext(Configuration::class.java)

    val action: SaveUser = context.getBean(SaveUser::class.java)

    action.execute()
}

class SaveUser(val dbConnection: DatabaseConnection) {
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
