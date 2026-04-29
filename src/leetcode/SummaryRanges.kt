package leetcode

class SummaryRanges {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) {
            return emptyList()
        }

        if (nums.size == 1) {
            return listOf(nums[0].toString())
        }

        val result = mutableListOf<String>()
        var first: Int = nums[0]

        for (i in 1..<nums.size) {
            if (nums[i].toLong()-nums[i-1]>1) {
                if (first != nums[i-1]) {
                    result += first.toString() + "->" + nums[i-1]
                } else {
                    result += first.toString()
                }
                first = nums[i]
            }
        }

        if (first != nums[nums.size-1]) {
            result += first.toString() + "->" + nums[nums.size-1]
        } else {
            result += first.toString()
        }

        return result
    }
}

fun main() {
    val solution = SummaryRanges()

    check(solution.summaryRanges(intArrayOf()) == listOf<Int>())
    check(solution.summaryRanges(intArrayOf(0)) == listOf("0"))
    check(solution.summaryRanges(intArrayOf(0,0)) == listOf("0"))
    check(solution.summaryRanges(intArrayOf(0,1)) == listOf("0->1"))
    check(solution.summaryRanges(intArrayOf(0,1,2,6,8,9)) == listOf("0->2","6","8->9"))
    check(solution.summaryRanges(intArrayOf(-2147483648,0,2,3,4,6,8,9)) == listOf("-2147483648","0","2->4","6","8->9"))

    println("ok")
}