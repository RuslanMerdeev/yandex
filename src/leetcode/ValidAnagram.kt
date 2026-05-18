package leetcode

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        val tt: StringBuilder = StringBuilder(t)

        if (s.length != t.length) {
            return false
        }

        if (s.isEmpty()) {
            return true
        }

        for (c in s) {
            val index = tt.indexOf(c)
            if (index != -1) {
                tt.deleteAt(index)
            } else {
                return false
            }
        }

        return true
    }
}

fun main() {
    val solution = ValidAnagram()

    check(solution.isAnagram("", ""))
    check(solution.isAnagram("s", "s"))
    check(!solution.isAnagram("s", "t"))
    check(solution.isAnagram("st", "ts"))
    check(solution.isAnagram("anagram", "nagaram"))
    check(!solution.isAnagram("rat", "car"))
    check(!solution.isAnagram("aacc", "ccac"))

    println("ok")
}