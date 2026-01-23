package leetcode

class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        val size = digits.size

        val result = IntArray(size)

        var offset = 0
        for (i in size-1 downTo 0) {
            var currDigit = digits[i]

            if (i == size-1) {
                currDigit++
            }

            currDigit += offset

            if (currDigit >= 10) {
                currDigit -= 10
                offset = 1
            } else {
                offset = 0
            }

            result[i] = currDigit
        }

        if (offset != 0) {
            val altResult = IntArray(size+1)
            altResult[0] = 1
            for (i in 1.. altResult.size-1) {
                altResult[i] = 0
            }
            return altResult
        }

        return result
    }
}

fun main() {
    val solution = PlusOne()

    check(solution.plusOne(intArrayOf(0)).contentEquals(intArrayOf(1)))
    check(solution.plusOne(intArrayOf(1,2,3)).contentEquals(intArrayOf(1,2,4)))
    check(solution.plusOne(intArrayOf(4,3,2,1)).contentEquals(intArrayOf(4,3,2,2)))
    check(solution.plusOne(intArrayOf(9)).contentEquals(intArrayOf(1,0)))
    check(solution.plusOne(intArrayOf(9,9,9,9)).contentEquals(intArrayOf(1,0,0,0,0)))

    println("ok")
}