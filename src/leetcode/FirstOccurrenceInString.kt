package leetcode

class FirstOccurrenceInString {
    fun strStr(haystack: String, needle: String): Int {
        if (haystack.isEmpty() || needle.isEmpty()) {
            return -1
        }

        if (haystack.length < needle.length) {
            return -1
        }

        var index = 0

        do {
            var needleIndex = 0
            do {
                val needleChar = needle[needleIndex]
                val char = haystack[index+needleIndex]
                if (char != needleChar) {
                    break
                }
                needleIndex++
            } while (needleIndex < needle.length)

            if (needleIndex == needle.length) {
                return index
            }

            index++
        } while (index+needle.length <= haystack.length)

        return -1
    }
}

fun main() {
    val solution = FirstOccurrenceInString()
    check(solution.strStr("", "") == -1)
    check(solution.strStr("", "ada") == -1)
    check(solution.strStr("adaf", "") == -1)
    check(solution.strStr("aaaaa", "a") == 0)
    check(solution.strStr("sfsffafer", "fa") == 4)
    check(solution.strStr("sdffg", "adasdfassdff") == -1)
    println("ok")
}