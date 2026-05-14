package leetcode

class PowerOfTwo {
    fun isPowerOfTwo(n: Int): Boolean {
        var count = 0
        var number = n
        do {
            if (number % 2 > 0) {
                count++
            }
            number /= 2
        } while (number != 0)

        return count == 1
    }
}

fun main() {
    val solution = PowerOfTwo()

    check(!solution.isPowerOfTwo(0))
    check(solution.isPowerOfTwo(1))
    check(solution.isPowerOfTwo(2))
    check(!solution.isPowerOfTwo(3))
    check(solution.isPowerOfTwo(16))

    println("ok")
}