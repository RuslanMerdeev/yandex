import org.example.RisingTemperature
import org.junit.jupiter.api.Test
import utils.executeQuery
import utils.initH2
import java.sql.Connection

class RisingTemperatureTest {

    fun createTestTables(connection: Connection) {
        val createTableSQL = """
        CREATE TABLE IF NOT EXISTS Weather (
            id INTEGER PRIMARY KEY,
            recordDate DATE UNIQUE,
            temperature INTEGER
        );
        """.trimIndent()

        connection.createStatement().execute(createTableSQL)
        println("📋 Таблицы созданы")

        // Очистка таблиц
        connection.createStatement().execute("""
            TRUNCATE TABLE Weather RESTART IDENTITY;
            """.trimIndent())

        val insertSQL = """
        INSERT INTO Weather (id, recordDate, temperature) VALUES
        (1, '2015-01-01', 10),
        (2, '2015-01-02', 25),
        (3, '2015-01-03', 20),
        (4, '2015-01-04', 30);
        """.trimIndent()

        connection.createStatement().execute(insertSQL)
        println("📊 Тестовые данные вставлены\n")
    }

    @Test
    fun select() {
        initH2(
            { connection ->  createTestTables(connection) },
            { connection ->
                val result = executeQuery(connection, RisingTemperature().select().trimIndent())

                assert(result.size == 2)
                with(result[0]) {
                    assert(this["id"] == "2")
                }
                with(result[1]) {
                    assert(this["id"] == "4")
                }
            },
        )
    }

}