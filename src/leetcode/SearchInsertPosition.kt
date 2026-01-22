package leetcode

class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        val size = nums.size

        if (size == 0) {
            return 0
        }

        var left = 0
        var right = size-1
        while (left <= right) {
            val mid = left + (right - left)/2

            when {
                nums[mid] < target -> left=mid+1
                nums[mid] > target -> right=mid-1
                else -> return mid
            }
        }

        return left
    }
}

fun main() {
    val solution = SearchInsertPosition()
    check(solution.searchInsert(intArrayOf(), 3) == 0)
    check(solution.searchInsert(intArrayOf(3), 2) == 0)
    check(solution.searchInsert(intArrayOf(3), 4) == 1)
    check(solution.searchInsert(intArrayOf(1,2,3,4,5), 3) == 2)
    check(solution.searchInsert(intArrayOf(1,3,4,5), 2) == 1)
    check(solution.searchInsert(intArrayOf(1,2,3,4,5), 10) == 5)
    check(solution.searchInsert(intArrayOf(1,2,3,4,5), -10) == 0)
    check(solution.searchInsert(intArrayOf(1,3,5), 2) == 1)
    println("ok")
}