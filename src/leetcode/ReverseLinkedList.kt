package leetcode

import leetcode.utils.ListNode

class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        var current: ListNode = head
        var next = current.next
        var prev: ListNode? = null
        while (next != null) {
            current.next = prev
            prev = current
            current = next
            next = current.next
        }

        current.next = prev

        return current
    }
}

fun main() {
    val solution = ReverseLinkedList()

    check(solution.reverseList(null) == null)
    check(solution.reverseList(ListNode(1))!!.compare(ListNode(1)))
    check(solution.reverseList(ListNode(1, ListNode(2, ListNode(3))))!!.compare(ListNode(3, ListNode(2, ListNode(1)))))

    println("ok")
}