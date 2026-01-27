package leetcode

class Sqrt {
    fun mySqrt(x: Int): Int {

        var left = 0
        var right = x

        while (left <= right) {
            val mid = left + (right-left)/2

            val guess = mid.toLong()*mid.toLong()

            when {
                guess < x -> left = mid+1
                guess > x -> right = mid-1
                x.toLong() == guess -> return mid
            }
        }

        return right
    }
}

fun main() {
    val solution = Sqrt()

    check(solution.mySqrt(0) == 0)
    check(solution.mySqrt(1) == 1)
    check(solution.mySqrt(2) == 1)
    check(solution.mySqrt(3) == 1)
    check(solution.mySqrt(4) == 2)
    check(solution.mySqrt(120) == 10)
    check(solution.mySqrt(2147483647) == 46340)

    println("ok")
}