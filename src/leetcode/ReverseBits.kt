package leetcode

class ReverseBits {
    fun reverseBits(n: Int): Int {
        if (n == 0) {
            return 0
        }

        if (n % 2 > 0) {
            throw RuntimeException()
        }

        var mask = 0b01000000000000000000000000000000
        var antiMask = 2
        var result = 0

        do {
            if (n.and(mask) > 0) {
                result = result.or(antiMask)
            }
            mask /= 2
            antiMask *= 2
        } while (mask > 1)

        return result
    }
}

fun main() {
    val solution = ReverseBits()

    check(solution.reverseBits(0) == 0)
//    check(solution.reverseBits(1) == 1073741824)
//    check(solution.reverseBits(1073741824) == 1)
    check(solution.reverseBits(2147483644) == 1073741822)
    check(solution.reverseBits(43261596) == 964176192)

    println("ok")
}