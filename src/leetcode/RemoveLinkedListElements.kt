package leetcode

import leetcode.utils.ListNode

class RemoveLinkedListElements {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) {
            return null
        }

        var result: ListNode? = null
        var prevPtr: ListNode? = null
        var ptr: ListNode? = head
        do {
            if (ptr!!.`val` != `val`) {
                if (result == null) {
                    result = ptr
                }
                prevPtr = ptr
            } else {
                if (prevPtr != null) {
                    prevPtr.next = ptr.next
                }
            }
            ptr = ptr.next
        } while (ptr != null)

        return result
    }
}

fun main() {
    val solution = RemoveLinkedListElements()

    check(solution.removeElements(null, 0) == null)
    check(solution.removeElements(ListNode(0), 0) == null)
    check(solution.removeElements(ListNode(0, ListNode(0)), 0) == null)
    check(solution.removeElements(ListNode(1, ListNode(0)), 0)!!.compare(ListNode(1)))
    check(solution.removeElements(ListNode(1, ListNode(0)), 1)!!.compare(ListNode(0)))

    println("ok")
}