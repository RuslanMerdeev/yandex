package leetcode

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        val size = strs.size

        if (size == 0) {
            return ""
        }

        if (size == 1) {
            return strs[0]
        }

        var index = 1
        var prefix = strs[0]

        while (index < size) {
            val curr = strs[index]
            if (curr.isEmpty() || prefix.isEmpty()) {
                prefix = ""
                break
            }

            var i = 0
            while (i < prefix.length && i < curr.length) {
                if (prefix[i] != curr[i]) {
                    break
                }
                i++
            }

            prefix = prefix.take(i)
            index++
        }

        return prefix
    }
}

fun main() {
    val solution = LongestCommonPrefix()
    check(solution.longestCommonPrefix(arrayOf()) == "")
    check(solution.longestCommonPrefix(arrayOf("")) == "")
    check(solution.longestCommonPrefix(arrayOf("", "")) == "")
    check(solution.longestCommonPrefix(arrayOf("a", "")) == "")
    check(solution.longestCommonPrefix(arrayOf("a", "b")) == "")
    check(solution.longestCommonPrefix(arrayOf("a", "a")) == "a")
    check(solution.longestCommonPrefix(arrayOf("aa", "a")) == "a")
    check(solution.longestCommonPrefix(arrayOf("ab", "abc")) == "ab")
    check(solution.longestCommonPrefix(arrayOf("abcakdklsa", "abcofjdslkf")) == "abc")
    check(solution.longestCommonPrefix(arrayOf("skdjhfabc", "abcdasdad")) == "")
    println("ok")
}