package leetcode

import leetcode.utils.ListNode

class LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }

        val nexts = mutableListOf<ListNode>()
        var next: ListNode? = head.next
        while (next != null && next !in nexts) {
            nexts.add(next)
            next = next.next
        }
        if (next in nexts) {
            return true
        }

        return false
    }
}

fun main() {
    val solution = LinkedListCycle()

    check(!solution.hasCycle(null))
    check(!solution.hasCycle(ListNode(0)))
    check(!solution.hasCycle(ListNode(0, ListNode(1))))
    check(!solution.hasCycle(ListNode(0, ListNode(1, ListNode(2)))))
    check(solution.hasCycle(run {
        val joint = ListNode(1)
        joint.let { it.next = ListNode(1, ListNode(2, ListNode(3, it))) }
        ListNode(0, joint)
    }))

    println("ok")
}