package leetcode

class Solution {
    fun isPalindrome(x: Int): Boolean {
        val array = x.toString().toCharArray()
        val size = array.size
        if (size == 1) {
            return true
        }

        var left = 0
        var right = size-1

        do {
            if (array.get(left) != array.get(right)) {
                return false
            }
            left++
            right--
        } while (left < right)

        return true
    }
}

fun main() {
    val solution = Solution()
    check(solution.isPalindrome(1))
    check(solution.isPalindrome(11))
    check(!solution.isPalindrome(-11))
    check(solution.isPalindrome(121))
    check(!solution.isPalindrome(124235345))
    check(solution.isPalindrome(0))
    println("ok")
}