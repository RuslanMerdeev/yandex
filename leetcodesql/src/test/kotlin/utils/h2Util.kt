package utils

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


fun initH2(preparing: (connection: Connection) -> Unit, performing: (connection: Connection) -> Unit) {
    var connection: Connection? = null

    try {
        // Загрузка H2 драйвера
        Class.forName("org.h2.Driver")

        // Подключение к in-memory базе данных
        // DB_CLOSE_DELAY=-1 - база не закрывается пока работает JVM
        // MODE=PostgreSQL - режим совместимости с PostgreSQL
        connection = DriverManager.getConnection(
            "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL",
            "sa",
            ""
        )

        println("✅ Внутренняя база данных H2 запущена (in-memory)")
        println("📌 Режим совместимости: PostgreSQL\n")

        preparing(connection)
        performing(connection)

    } catch (_: ClassNotFoundException) {
        println("❌ H2 JDBC Driver не найден")
        println("Добавьте зависимость в build.gradle.kts: implementation(\"com.h2database:h2:2.2.224\")")
    } catch (e: SQLException) {
        println("❌ Ошибка базы данных: ${e.message}")
    } finally {
        connection?.close()
        println("\n🔌 Соединение закрыто")
    }
}

fun executeQuery(connection: Connection, query: String): List<Map<String, String>> {
    val result = mutableListOf<Map<String, String>>()
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery(query)

    val metaData = resultSet.metaData
    val columnCount = metaData.columnCount

    while (resultSet.next()) {
        val row = mutableMapOf<String, String>()
        for (i in 1..columnCount) {
            val columnName = metaData.getColumnName(i)
            val value = resultSet.getString(i)
            row[columnName.lowercase()] = value ?: "null"
        }
        result.add(row)
    }

    resultSet.close()
    statement.close()
    return result
}