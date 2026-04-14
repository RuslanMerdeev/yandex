package org.example

class DeleteDuplicateEmails {

    fun select() = """
        SELECT * 
        FROM Person
        """

    fun delete() = """
        DELETE FROM Person 
        WHERE id NOT IN (
            SELECT MIN(id) 
            FROM Person 
            GROUP BY email
        )
        """
}