import org.example.DuplicateEmails
import org.junit.jupiter.api.Test
import utils.executeQuery
import utils.initH2
import java.sql.Connection

class DuplicateEmailsTest {

    fun createTestTables(connection: Connection) {
        val createTableSQL = """
        CREATE TABLE IF NOT EXISTS Person (
            id INTEGER PRIMARY KEY,
            email VARCHAR(100) NOT NULL
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
        (1, 'a@b.com'),
        (2, 'c@d.com'),
        (3, 'a@b.com');
        """.trimIndent()

        connection.createStatement().execute(insertSQL)
        println("📊 Тестовые данные вставлены\n")
    }

    @Test
    fun select() {
        initH2(
            { connection ->  createTestTables(connection) },
            { connection ->
                val result = executeQuery(connection, DuplicateEmails().select().trimIndent())

                assert(result.size == 1)
                with(result[0]) {
                    assert(this["email"] == "a@b.com")
                }
            },
        )
    }

}