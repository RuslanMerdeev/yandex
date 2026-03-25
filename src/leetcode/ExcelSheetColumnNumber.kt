package leetcode

import kotlin.math.pow

class ExcelSheetColumnNumber {
    fun titleToNumber(columnTitle: String): Int {
        var result = 0
        var power = columnTitle.length-1

        for (char in columnTitle) {
            val value = MAP[char.toString()]!! + 1
            result += value * 26.toDouble().pow(power.toDouble()).toInt()
            power--
        }

        return result
    }
    
    private val MAP = mapOf(
        "A" to 0,
        "B" to 1,
        "C" to 2,
        "D" to 3,
        "E" to 4,
        "F" to 5,
        "G" to 6,
        "H" to 7,
        "I" to 8,
        "J" to 9,
        "K" to 10,
        "L" to 11,
        "M" to 12,
        "N" to 13,
        "O" to 14,
        "P" to 15,
        "Q" to 16,
        "R" to 17,
        "S" to 18,
        "T" to 19,
        "U" to 20,
        "V" to 21,
        "W" to 22,
        "X" to 23,
        "Y" to 24,
        "Z" to 25,
    )
}

fun main() {
    val solution = ExcelSheetColumnNumber()

    check(solution.titleToNumber("A") == 1)
    check(solution.titleToNumber("B") == 2)
    check(solution.titleToNumber("Z") == 26)
    check(solution.titleToNumber("AA") == 27)
    check(solution.titleToNumber("AB") == 28)
    check(solution.titleToNumber("ZY") == 701)

    println("ok")
}