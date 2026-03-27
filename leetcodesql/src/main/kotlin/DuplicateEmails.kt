package org.example

class DuplicateEmails {
//    fun select() = """
//        SELECT p.email as Email
//        FROM (
//            SELECT e.email, count(e.email)
//            FROM Person as e
//            GROUP BY email
//            HAVING COUNT(e.email) > 1
//        ) as p
//    """.trimIndent()

    fun select() = """
        SELECT e.email as Email
        FROM Person as e
        GROUP BY email
        HAVING COUNT(e.email) > 1
    """.trimIndent()
}