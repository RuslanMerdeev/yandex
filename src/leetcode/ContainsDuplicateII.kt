package leetcode

class ContainsDuplicateII {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = mutableMapOf<Int, ArrayList<Int>>()
        var i = 0
        for (num in nums) {
            val mapNum = map[num]
            if (mapNum == null) {
                map[num] = arrayListOf(i)
            } else {
                if (i- mapNum[mapNum.size-1] <= k) {
                    return true
                }
                mapNum.add(i)
            }
            i++
        }
        return false
    }
}

fun main() {
    val solution = ContainsDuplicateII()

    check(!solution.containsNearbyDuplicate(intArrayOf(1),100))
    check(solution.containsNearbyDuplicate(intArrayOf(1,1),100))
    check(!solution.containsNearbyDuplicate(intArrayOf(1,2,3,4),100))
    check(solution.containsNearbyDuplicate(intArrayOf(1,2,3,1),3))
    check(solution.containsNearbyDuplicate(intArrayOf(1,0,1,1),1))
    check(!solution.containsNearbyDuplicate(intArrayOf(1,2,3,1,2,3),2))

    println("ok")
}