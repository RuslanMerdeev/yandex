package leetcode

import java.util.Queue

class StackUsingQueue {
    val queue = ArrayDeque<Int>()

    fun push(x: Int) {
        queue.add(x)
    }

    fun pop(): Int {
        val item = queue.last()
        queue.removeLast()
        return item
    }

    fun top(): Int {
        return queue.last()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }
}

fun main() {
    val solution = StackUsingQueue()
    solution.push(1)
    solution.push(2)

    check(solution.top() == 2)
    check(solution.pop() == 2)
    check(!solution.empty())

    println("ok")
}