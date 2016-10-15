fun main(args: Array<String>) {
    val connection: DatabaseConnection = MySqlConnection()
    val action: SaveUser = SaveUser(connection)

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
