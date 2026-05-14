package leetcode


class QueueUsingStacks {

    val stack = ArrayDeque<Int>()

    fun push(x: Int) {
        stack.addLast(x)
    }

    fun pop(): Int {
        val first = stack.first()
        stack.removeFirst()
        return first
    }

    fun peek(): Int {
        return stack.first()
    }

    fun empty(): Boolean {
        return stack.isEmpty()
    }
}

fun main() {
    val solution = QueueUsingStacks()

    solution.push(1)
    solution.push(2)
    check(solution.peek() == 1)
    check(solution.pop() == 1)
    val empty = solution.empty()
    check(!empty)

    println("ok")
}