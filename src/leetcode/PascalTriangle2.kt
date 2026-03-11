package leetcode

class PascalTriangle2 {
//    fun getRow(rowIndex: Int): List<Int> {
//        val result = mutableListOf(1)
//        for (i in 0 until rowIndex) {
//            var curr = result[0]
//            for (j in 1 until result.size) {
//                result[j] = result[j-1] + curr
//                curr = result[]
//            }
//        }
//
//        return result
//    }

    fun getRow(rowIndex: Int): List<Int> {
        if (rowIndex == 0) {
            return listOf(1)
        }

        return row(listOf(1), rowIndex)
    }

    private fun row(prevRow: List<Int>, rowIndex: Int): List<Int> {
        val result = mutableListOf(1)
        for (i in 0 until prevRow.size-1) {
            result.add(prevRow[i]+prevRow[i+1])
        }
        result.add(1)
        if (result.size == rowIndex+1) {
            return result
        }
        return row(result, rowIndex)
    }
}

fun main() {
    val solution = PascalTriangle2()

    check(solution.getRow(0) == listOf(1))
    check(solution.getRow(1) == listOf(1,1))
    check(solution.getRow(2) == listOf(1,2,1))
    check(solution.getRow(3) == listOf(1,3,3,1))
    check(solution.getRow(4) == listOf(1,4,6,4,1))
    check(solution.getRow(5) == listOf(1,5,10,10,5,1))

    println("ok")
}