package leetcode

class HappyNumber {
    fun isHappy(n: Int): Boolean {
        var number = n
        val list = mutableListOf<Int>()

        do {
            var whole = number
            var result = 0
            do {
                list += number
                val remain = whole % 10
                result += remain * remain
                whole /= 10
            } while (whole > 0)
            number = result
        } while (number != 1 && number !in list)

        return number == 1
    }
}

fun main() {
    val solution = HappyNumber()

    check(solution.isHappy(19))
    check(!solution.isHappy(2))
    check(solution.isHappy(1))

    println("ok")
}