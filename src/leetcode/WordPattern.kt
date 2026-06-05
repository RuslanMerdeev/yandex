package leetcode

class WordPattern {
    fun wordPattern(pattern: String, s: String): Boolean {
        if (pattern.length != s.count { it == ' ' } + 1 ) {
            return false
        }

        val m = mutableMapOf<Char, String>()
        var i = 0
        for (w in s.split(' ')) {
            val c = pattern[i]
            val saved = m[c]
            if (saved != null) {
                if (saved != w) {
                    return false
                }
            } else {
                m[c] = w
                if (m.values.count { it == w } > 1) {
                    return false
                }
            }
            i++
        }
        return true
    }
}

fun main () {
    val solution = WordPattern()

    check(solution.wordPattern("abba", "dog cat cat dog"))
    check(!solution.wordPattern("abba", "dog cat cat fish"))
    check(!solution.wordPattern("aaaa", "dog cat cat dog"))
    check(!solution.wordPattern("abba", "dog dog dog dog"))

    println("ok")
}