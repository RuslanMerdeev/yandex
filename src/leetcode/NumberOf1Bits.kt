package leetcode

class NumberOf1Bits {

    fun hammingWeight(n: Int): Int {
        var mask = 0x40000000
        var setBits = 0
        do {
            if (n.and(mask) > 0) {
                setBits++
            }
            mask /= 2
        } while (mask > 0)

        return setBits
    }
}

fun main() {
    val solution = NumberOf1Bits()

    check(solution.hammingWeight(0) == 0)
    check(solution.hammingWeight(1) == 1)
    check(solution.hammingWeight(3) == 2)
    check(solution.hammingWeight(128) == 1)
    check(solution.hammingWeight(2147483645) == 30)

    println("ok")
}