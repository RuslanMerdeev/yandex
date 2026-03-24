package leetcode

class ExcelSheetColumnTitle {
    fun convertToTitle(columnNumber: Int): String {
        var result = ""
        var whole = columnNumber
        var remaining: Int
        do {
            whole--
            remaining = whole % 26
            whole /= 26

            result = MAP[remaining] + result
        } while (whole != 0)

        return result
    }

    companion object{
        private val MAP = mapOf<Int, String>(
            0 to "A",
            1 to "B",
            2 to "C",
            3 to "D",
            4 to "E",
            5 to "F",
            6 to "G",
            7 to "H",
            8 to "I",
            9 to "J",
            10 to "K",
            11 to "L",
            12 to "M",
            13 to "N",
            14 to "O",
            15 to "P",
            16 to "Q",
            17 to "R",
            18 to "S",
            19 to "T",
            20 to "U",
            21 to "V",
            22 to "W",
            23 to "X",
            24 to "Y",
            25 to "Z",
        )
    }
}

fun main() {
    val solution = ExcelSheetColumnTitle()

    check(solution.convertToTitle(1) == "A")
    check(solution.convertToTitle(26) == "Z")
    check(solution.convertToTitle(27) == "AA")
    check(solution.convertToTitle(28) == "AB")
    check(solution.convertToTitle(701) == "ZY")

    println("ok")
}