package leetcode

class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        val size = s.length

        if(size == 0) {
            return 0
        }

        var wordLength = 0

        for (i in size-1 downTo 0){
            val currChar = s[i]

            if (currChar != ' ') {
                wordLength++
            } else {
                if (wordLength != 0) {
                    break
                }
            }
        }

        return wordLength
    }
}

fun main() {
    val solution = LengthOfLastWord()

    check(solution.lengthOfLastWord("") == 0)
    check(solution.lengthOfLastWord(" ") == 0)
    check(solution.lengthOfLastWord("    ") == 0)
    check(solution.lengthOfLastWord("sss    ") == 3)
    check(solution.lengthOfLastWord("Hello World") == 5)
    check(solution.lengthOfLastWord("   fly me   to   the moon  ") == 4)
    check(solution.lengthOfLastWord("luffy is still joyboy") == 6)

    println("ok")
}