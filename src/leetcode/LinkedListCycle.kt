package leetcode

import leetcode.utils.ListNode

class LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }

        var fast = head
        var slow = head

        while (fast != null && fast.next != null) {
            fast = fast.next!!.next
            slow = slow!!.next

            if (fast == slow) {
                return true
            }
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