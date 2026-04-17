package org.example

class RisingTemperature {
    fun select() = """
        SELECT e.id
        FROM Weather as e
        LEFT JOIN Weather as p 
        ON (e.recordDate = p.recordDate + 1)
        WHERE e.temperature > p.temperature
    """.trimIndent()
}