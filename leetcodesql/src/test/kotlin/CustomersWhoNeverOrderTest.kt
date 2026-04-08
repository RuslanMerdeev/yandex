import org.example.CustomersWhoNeverOrder
import org.junit.jupiter.api.Test
import utils.executeQuery
import utils.initH2
import java.sql.Connection

class CustomersWhoNeverOrderTest {
    fun createTestTables(connection: Connection) {
        val createTableSQL = """
        CREATE TABLE IF NOT EXISTS Customers (
            id INTEGER PRIMARY KEY,
            name VARCHAR(100)
        );
        CREATE TABLE IF NOT EXISTS Orders (
            id INTEGER PRIMARY KEY,
            customerId INTEGER
        );
        """.trimIndent()

        connection.createStatement().execute(createTableSQL)
        println("📋 Таблицы созданы")

        // Очистка таблиц
        connection.createStatement().execute("""
            TRUNCATE TABLE Customers RESTART IDENTITY;
            TRUNCATE TABLE Orders RESTART IDENTITY;
            """.trimIndent())

        val insertSQL = """
        INSERT INTO Customers (id, name) VALUES
        (1, 'Joe'),
        (2, 'Henry'),
        (3, 'Sam'),
        (4, 'Max');
        INSERT INTO Orders (id, customerId) VALUES
        (1, 3),
        (2, 1);
        """.trimIndent()

        connection.createStatement().execute(insertSQL)
        println("📊 Тестовые данные вставлены\n")
    }

    @Test
    fun select() {
        initH2(
            { connection ->  createTestTables(connection) },
            { connection ->
                val result = executeQuery(connection, CustomersWhoNeverOrder().select().trimIndent())

                assert(result.size == 2)
                with(result[0]) {
                    assert(this["customers"] == "Henry")
                }
                with(result[1]) {
                    assert(this["customers"] == "Max")
                }
            },
        )
    }
}