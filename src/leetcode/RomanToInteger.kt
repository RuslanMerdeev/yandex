package leetcode

// I -> 1
// V -> 5
// X -> 10
// L -> 50
// C -> 100
// D -> 500
// M -> 1000
// VI -> 6
// MI -> 1001
// IV -> 4
// IM -> 999
// MDC -> 1600
// MCD -> 1400
// CDM -> 1400
// III -> 3

// c - текущее значение
// n-1 > n ->
// n-1 == n ->
// n-1 < n ->

class RomanToInteger {
    companion object {
        val map: Map<Char, Int> = mapOf(
            Pair('I', 1),
            Pair('V', 5),
            Pair('X', 10),
            Pair('L', 50),
            Pair('C', 100),
            Pair('D', 500),
            Pair('M', 1000),
        )
    }

    fun romanToInt(s: String): Int {
        if (s.length == 1) {
            return map(s[0])
        }

        var digit = 0
        var pos = 0
        while (pos < s.length) {
            val curr = map(s[pos])

            if (pos + 1 == s.length) {
                digit += curr
            } else {
                val next = map(s[pos + 1])

                if (curr < next) {
                    digit += next - curr
                    pos++
                } else {
                    digit += curr
                }
            }

            pos++
        }

        return digit
    }

    private fun map(curr: Char): Int = map[curr] ?: throw RuntimeException("incorrect letter")
}

fun main() {
    val romanToInteger = RomanToInteger()
    check(romanToInteger.romanToInt("MDCLXVI") == 1666)
    check(romanToInteger.romanToInt("I") == 1)
    check(romanToInteger.romanToInt("V") == 5)
    check(romanToInteger.romanToInt("X") == 10)
    check(romanToInteger.romanToInt("L") == 50)
    check(romanToInteger.romanToInt("C") == 100)
    check(romanToInteger.romanToInt("D") == 500)
    check(romanToInteger.romanToInt("M") == 1000)
    check(romanToInteger.romanToInt("VI") == 6)
    check(romanToInteger.romanToInt("MI") == 1001)
    check(romanToInteger.romanToInt("IV") == 4)
    check(romanToInteger.romanToInt("IM") == 999)
    check(romanToInteger.romanToInt("MDC") == 1600)
    check(romanToInteger.romanToInt("MCD") == 1400)
    check(romanToInteger.romanToInt("CDM") == 1400)
    check(romanToInteger.romanToInt("III") == 3)
    println("ok")
}