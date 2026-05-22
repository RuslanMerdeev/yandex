package leetcode

class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        var total = 0
        var sum = 0
        for(i in 0 until nums.size) {
            total += i
            sum += nums[i]
        }
        total += nums.size
        return total - sum
    }
}

fun main() {
    val solution = MissingNumber()

    check(solution.missingNumber(intArrayOf(1)) == 0)
    check(solution.missingNumber(intArrayOf(0,2)) == 1)
    check(solution.missingNumber(intArrayOf(4,2,0,1)) == 3)
    check(solution.missingNumber(intArrayOf(9,6,4,2,3,5,7,0,1)) == 8)

    println("ok")
}