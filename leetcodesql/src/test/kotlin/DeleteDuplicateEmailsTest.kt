import org.example.DeleteDuplicateEmails
import org.junit.jupiter.api.Test
import utils.execute
import utils.executeQuery
import utils.initH2
import java.sql.Connection

class DeleteDuplicateEmailsTest {

    fun createTestTables(connection: Connection) {
        val createTableSQL = """
        CREATE TABLE IF NOT EXISTS Person (
            id INTEGER PRIMARY KEY,
            email VARCHAR(100)
        );
        """.trimIndent()

        connection.createStatement().execute(createTableSQL)
        println("📋 Таблицы созданы")

        // Очистка таблиц
        connection.createStatement().execute("""
            TRUNCATE TABLE Person RESTART IDENTITY;
            """.trimIndent())

        val insertSQL = """
        INSERT INTO Person (id, email) VALUES
        (1, 'john@example.com'),
        (2, 'bob@example.com'),
        (3, 'john@example.com');
        """.trimIndent()

        connection.createStatement().execute(insertSQL)
        println("📊 Тестовые данные вставлены\n")
    }

    @Test
    fun select() {
        initH2(
            { connection ->  createTestTables(connection) },
            { connection ->
                execute(connection, DeleteDuplicateEmails().delete())
                val result = executeQuery(connection, DeleteDuplicateEmails().select().trimIndent())

                assert(result.size == 2)
                with(result[0]) {
                    assert(this["id"] == "1")
                    assert(this["email"] == "john@example.com")
                }
                with(result[1]) {
                    assert(this["id"] == "2")
                    assert(this["email"] == "bob@example.com")
                }
            },
        )
    }
}