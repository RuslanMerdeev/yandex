package leetcode

class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        if (nums.size > 1) {
            var left = 0
            var right = 1
            do {
                if (nums[left] == 0) {
                    while(nums[right] == 0 && right < nums.size-1) {
                        right++
                    }
                    val save = nums[left]
                    nums[left] = nums[right]
                    nums[right] = save
                }
                left++
                right++
            } while (right < nums.size)
        }
    }
}

fun main() {
    val solution = MoveZeroes()

    check(intArrayOf().let {
        solution.moveZeroes(it)
        it.contentEquals(intArrayOf())
    })
    check(intArrayOf(0).let {
        solution.moveZeroes(it)
        it.contentEquals(intArrayOf(0))
    })
    check(intArrayOf(0,1).let {
        solution.moveZeroes(it)
        it.contentEquals(intArrayOf(1,0))
    })
    check(intArrayOf(0,1,0,4).let {
        solution.moveZeroes(it)
        it.contentEquals(intArrayOf(1,4,0,0))
    })
    check(intArrayOf(0,1,0,3,12).let {
        solution.moveZeroes(it)
        it.contentEquals(intArrayOf(1,3,12,0,0))
    })

    println("ok")
}