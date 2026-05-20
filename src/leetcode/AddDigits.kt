package leetcode

class AddDigits {
    fun addDigits(num: Int): Int {
        if (num == 0) {
            return 0
        }
        val residue = num%9
        if (residue == 0) {
            return 9
        }
        return residue
    }
}

fun main() {
    val solution = AddDigits()

    check(solution.addDigits(0) == 0)
    check(solution.addDigits(1) == 1)
    check(solution.addDigits(9) == 9)
    check(solution.addDigits(10) == 1)
    check(solution.addDigits(19) == 1)
    check(solution.addDigits(20) == 2)
    check(solution.addDigits(28) == 1)
    check(solution.addDigits(37) == 1)

    println("ok")
}