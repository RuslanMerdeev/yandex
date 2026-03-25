import org.example.CombineTwoTables
import org.junit.jupiter.api.Test
import utils.executeQuery
import utils.initH2
import java.sql.Connection

class CombineTwoTablesTest {

    fun createTestTables(connection: Connection) {
        val createTableSQL = """
        CREATE TABLE IF NOT EXISTS Person (
            personId INTEGER PRIMARY KEY,
            lastName VARCHAR(100),
            firstName VARCHAR(100)
        );
        CREATE TABLE IF NOT EXISTS Address (
            addressId INTEGER PRIMARY KEY,
            personId INTEGER,
            city VARCHAR(100),
            state VARCHAR(100)
        );
        """.trimIndent()

        connection.createStatement().execute(createTableSQL)
        println("📋 Таблицы созданы")

        // Очистка таблиц
        connection.createStatement().execute("""
            TRUNCATE TABLE Person RESTART IDENTITY;
            TRUNCATE TABLE Address RESTART IDENTITY;
            """.trimIndent())

        val insertSQL = """
        INSERT INTO Person (personId, lastName, firstName) VALUES
        (1, 'Wang', 'Allen'),
        (2, 'Alice', 'Bob');
        INSERT INTO Address (addressId, personId, city, state) VALUES
        (1, 2, 'New York City', 'New York'),
        (2, 3, 'Leetcode', 'California');
        """.trimIndent()

        connection.createStatement().execute(insertSQL)
        println("📊 Тестовые данные вставлены\n")
    }

    @Test
    fun combine() {
        initH2(
            { connection ->  createTestTables(connection) },
            { connection ->
                val result = executeQuery(connection, CombineTwoTables().combine().trimIndent())

                assert(result.size == 2)
                with(result[0]) {
                    assert(this["firstname"] == "Allen")
                    assert(this["lastname"] == "Wang")
                    assert(this["city"] == "null")
                    assert(this["state"] == "null")
                }
                with(result[1]) {
                    assert(this["firstname"] == "Bob")
                    assert(this["lastname"] == "Alice")
                    assert(this["city"] == "New York City")
                    assert(this["state"] == "New York")
                }
            },
        )
    }
}