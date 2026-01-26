package leetcode

class AddBinary {
    fun addBinary(a: String, b: String): String {
        var result = ""

        val aLength = a.length
        val bLength = b.length

        var delta = aLength-bLength
        if (delta < 0) {
            delta = -delta
        }

        var zeros = ""
        for (i in 1 .. delta) {
            zeros += "0"
        }

        var aNew = a
        var bNew = b
        if (aLength-bLength > 0) {
            bNew = zeros+bNew
        } else {
            aNew = zeros+aNew
        }

        var remain = 0
        for (i in aNew.length-1 downTo 0) {
            val first = aNew[i].digitToInt()
            val second = bNew[i].digitToInt()

            var add = first+second+remain

            if (add > 1) {
                remain=add/2
                add%=2
            } else {
                remain = 0
            }

            result=add.toString()+result
        }

        while (remain > 0) {
            result="1"+result
            remain--
        }

        return result
    }
}

fun main() {
    val solution = AddBinary()

    check(solution.addBinary("0", "0") == "0")
    check(solution.addBinary("1", "0") == "1")
    check(solution.addBinary("111111", "1") == "1000000")
    check(solution.addBinary("1", "111111") == "1000000")
    check(solution.addBinary("1110", "1") == "1111")
    check(solution.addBinary("1010", "1011") == "10101")
    check(solution.addBinary("1111", "1111") == "11110")

    println("ok")
}