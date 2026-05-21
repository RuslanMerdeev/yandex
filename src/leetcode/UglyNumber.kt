package leetcode

class UglyNumber {
    fun isUgly(n: Int): Boolean {
        if (n <= 0) {
            return false
        }

        if (n == 1) {
            return true
        }

        var result = n

        do {
            if (result % 2 != 0 && result % 3 != 0 && result % 5 != 0) {
                return false
            }
            if (result % 2 == 0) {
                result /= 2
            }
            if (result % 3 == 0) {
                result /= 3
            }
            if (result % 5 == 0) {
                result /= 5
            }
        } while (result != 1)
        return true
    }
}

fun main() {
    val solution = UglyNumber()

    check(!solution.isUgly(0))
    check(solution.isUgly(1))
    check(!solution.isUgly(-1))
    check(solution.isUgly(2))
    check(!solution.isUgly(-2))
    check(solution.isUgly(3))
    check(solution.isUgly(4))
    check(solution.isUgly(5))
    check(solution.isUgly(6))
    check(!solution.isUgly(7))
    check(!solution.isUgly(14))
    check(!solution.isUgly(-14))
    check(!solution.isUgly(-2147483648))

    println("ok")
}