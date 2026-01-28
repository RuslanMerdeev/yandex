package leetcode

class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        var a = 0
        var b = 1

        for (i in 0 until n) {
            val temp = a
            a = b
            b += temp
        }

        return b
    }
}

fun main() {
    val solution = ClimbingStairs()

    check(solution.climbStairs(1) == 1)
    check(solution.climbStairs(2) == 2)
    check(solution.climbStairs(3) == 3)
    check(solution.climbStairs(4) == 5) // .... -- .-. ..- -..
    check(solution.climbStairs(5) == 8) // ..... --. .-.. ..-. -... ...- .-- -.-

    println("ok")
}