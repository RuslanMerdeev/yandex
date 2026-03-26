import org.example.EmployeesEarningMoreThanTheirManagers
import org.junit.jupiter.api.Test
import utils.executeQuery
import utils.initH2
import java.sql.Connection

class EmployeesEarningMoreThanTheirManagersTest {

    fun createTestTables(connection: Connection) {
        val createTableSQL = """
        CREATE TABLE IF NOT EXISTS Employee (
            id INTEGER PRIMARY KEY,
            name VARCHAR(100),
            salary INTEGER,
            managerId INTEGER
        );
        """.trimIndent()

        connection.createStatement().execute(createTableSQL)
        println("📋 Таблицы созданы")

        // Очистка таблиц
        connection.createStatement().execute("""
            TRUNCATE TABLE Employee RESTART IDENTITY;
            """.trimIndent())

        val insertSQL = """
        INSERT INTO Employee (id, name, salary, managerId) VALUES
        (1, 'Joe', 70000, 3),
        (2, 'Henry', 80000, 4),
        (3, 'Sam', 60000, Null),
        (4, 'Max', 90000, Null);
        """.trimIndent()

        connection.createStatement().execute(insertSQL)
        println("📊 Тестовые данные вставлены\n")
    }

    @Test
    fun select() {
        initH2(
            { connection ->  createTestTables(connection) },
            { connection ->
                val result = executeQuery(connection, EmployeesEarningMoreThanTheirManagers().select().trimIndent())

                assert(result.size == 1)
                with(result[0]) {
                    assert(this["employee"] == "Joe")
                }
            },
        )
    }
}