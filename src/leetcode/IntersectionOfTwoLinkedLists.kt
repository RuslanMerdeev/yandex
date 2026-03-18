package leetcode

import leetcode.utils.ListNode

class IntersectionOfTwoLinkedLists {
    fun getIntersectionNode(headA: ListNode?, headB:ListNode?):ListNode? {
        if (headA == null || headB == null) {
            return null
        }

        val (endOfA, sizeOfA) = skip(headA)
        val (endOfB, sizeOfB) = skip(headB)


        if (endOfA == endOfB) {
            return if (sizeOfB-sizeOfA > 0) {
                find(skip(headB, sizeOfB-sizeOfA).first, headA)
            } else {
                find(skip(headA, sizeOfA-sizeOfB).first, headB)
            }
        }

        return null
    }

    private fun skip(head: ListNode, skip: Int? = null): Pair<ListNode, Int> {
        var end = head
        var skipped = 0
        while (end.next != null && (skip == null || skipped < skip)) {
            end = end.next!!
            skipped++
        }
        return Pair(end,skipped)
    }

    private fun find(headA: ListNode, headB: ListNode): ListNode? {
        var currA = headA
        var currB = headB
        while (currA != currB && currA.next != null && currB.next != null) {
            currA=currA.next!!
            currB=currB.next!!
        }
        if (currA == currB) {
            return currA
        }
        return null
    }
}

fun main() {
    val solution = IntersectionOfTwoLinkedLists()

    check(solution.getIntersectionNode(null, null) == null)
    check(solution.getIntersectionNode(ListNode(0), null) == null)
    check(solution.getIntersectionNode(null, ListNode(0)) == null)
    check(solution.getIntersectionNode(ListNode(0), ListNode(0)) == null)
    check(solution.getIntersectionNode(ListNode(0, ListNode(1, ListNode(2))), ListNode(0)) == null)
    run {
        val commonNone = ListNode(0, ListNode(1, ListNode(2)))
        check(solution.getIntersectionNode(ListNode(0, commonNone), ListNode(0, commonNone)) == commonNone)
    }
    run {
        val commonNone = ListNode(0, ListNode(1, ListNode(2)))
        check(solution.getIntersectionNode(commonNone, commonNone) == commonNone)
    }
    println("ok")
}