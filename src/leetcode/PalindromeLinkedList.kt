package leetcode

import leetcode.utils.ListNode

class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }

        var count = 0
        var cur: ListNode? = head
        do {
            count++
            cur = cur!!.next
        } while (cur != null)

        if (count == 1) {
            return true
        }

        var current: ListNode? = head
        var next: ListNode? = head
        var prev: ListNode? = null
        for (i in 0 until count/2) {
            next = next!!.next
            current!!.next = prev
            prev = current
            current = next
        }

        var straight: ListNode = current!!
        if (count%2 > 0) {
            straight = straight.next!!
        }

        return prev!!.compare(straight)
    }
}

fun main() {
    val solution = PalindromeLinkedList()

    check(!solution.isPalindrome(null))
    check(solution.isPalindrome(ListNode(1)))
    check(solution.isPalindrome(ListNode(1, ListNode(1))))
    check(!solution.isPalindrome(ListNode(1, ListNode(2))))
    check(solution.isPalindrome(ListNode(1, ListNode(2, ListNode(1)))))
    check(!solution.isPalindrome(ListNode(1, ListNode(2, ListNode(1, ListNode(2))))))

    println("ok")
}