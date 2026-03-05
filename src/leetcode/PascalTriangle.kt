package leetcode

class PascalTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf(listOf(1))

        if (numRows == 1) {
            return result
        }

        generateRow(numRows, result)

        return result
    }

    fun generateRow(numRows: Int, result: MutableList<List<Int>>) {
        val currentRow = mutableListOf(1)
        val prevRow = result.last()

        for(i in 0 .. prevRow.size-2) {
            currentRow.add(prevRow[i]+prevRow[i+1])
        }
        currentRow.add(1)
        result.add(currentRow)
        if (currentRow.size < numRows) {
            generateRow(numRows, result)
        }
    }
}

fun main() {
    val solution = PascalTriangle()

    check(solution.generate(1) == listOf(listOf(1)))
    check(solution.generate(2) == listOf(listOf(1), listOf(1,1)))
    check(solution.generate(3) == listOf(listOf(1), listOf(1,1), listOf(1,2,1)))
    check(solution.generate(4) == listOf(listOf(1), listOf(1,1), listOf(1,2,1), listOf(1,3,3,1)))
    check(solution.generate(5) == listOf(listOf(1), listOf(1,1), listOf(1,2,1), listOf(1,3,3,1), listOf(1,4,6,4,1)))
    check(solution.generate(6) == listOf(listOf(1), listOf(1,1), listOf(1,2,1), listOf(1,3,3,1), listOf(1,4,6,4,1), listOf(1,5,10,10,5,1)))

    println("ok")
}