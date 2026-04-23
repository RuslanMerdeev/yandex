package leetcode

class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        return nums.size != nums.toSet().size
    }
}

fun main() {
    val solution = ContainsDuplicate()

    check(!solution.containsDuplicate(intArrayOf(1)))
    check(solution.containsDuplicate(intArrayOf(1,1)))
    check(!solution.containsDuplicate(intArrayOf(1,2,3,4)))

    println("ok")
}