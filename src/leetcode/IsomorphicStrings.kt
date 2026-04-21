package leetcode

class IsomorphicStrings {
    fun isIsomorphic(s: String, t: String): Boolean {
        if(s.length != t.length) {
            return false
        }

        val map = mutableMapOf<Char, Char>()

        for (i in 0 until  s.length) {
            val char = map[s[i]]
            if (char == null) {
                if (map.values.contains(t[i])) {
                    return false
                }
                map[s[i]] = t[i]
            } else if(char != t[i]) {
                return false
            }
        }

        return true
    }
}

fun main() {
    val solution = IsomorphicStrings()

    check(solution.isIsomorphic("", ""))
    check(!solution.isIsomorphic("s", ""))
    check(solution.isIsomorphic("s", "t"))
    check(!solution.isIsomorphic("s", "ta"))
    check(solution.isIsomorphic("111", "222"))
    check(!solution.isIsomorphic("badc", "baba"))

    println("ok")
}