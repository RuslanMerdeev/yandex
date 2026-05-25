package leetcode

open class VersionControl(val firstBad: Int) {


    fun isBadVersion(version: Int) : Boolean {
        return version >= firstBad
    }

    open fun firstBadVersion(n: Int): Int {return 0}
}

class Solution(firstBad: Int): VersionControl(firstBad) {
    override fun firstBadVersion(n: Int) : Int {
        var left = 0
        var right = n
        do {
            val middle = (right-left)/2 + left
            if (isBadVersion(middle)) {
                right = middle
            } else {
                left = middle
            }
        } while(right-left > 1)
        return right
    }
}

fun main() {

    check(Solution(6).firstBadVersion(8) == 6)
    check(Solution(4).firstBadVersion(5) == 4)
    check(Solution(1).firstBadVersion(1) == 1)
    check(Solution(1).firstBadVersion(3) == 1)

    println("ok")
}