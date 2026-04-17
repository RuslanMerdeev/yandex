package org.example

class DuplicateEmails {
    fun select() = """
        SELECT e.email as Email
        FROM Person as e
        GROUP BY e.email
        HAVING COUNT(e.email) > 1
    """.trimIndent()
}