package leetcode

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    companion object {
        fun fromList(list: List<Int>?): ListNode? {
            if (list == null || list.isEmpty()) {
                return null
            }

            var ptr: ListNode? = ListNode(0)
            val result = ptr

            for (i in list) {
                ptr!!.next = ListNode(i)
                ptr = ptr.next
            }

            return result!!.next
        }
    }

    fun compare(list: ListNode?): Boolean {
        if(list == null) {
            return false
        }

        if (`val` != list.`val`) {
            return false
        }

        if ((next==null) != (list.next==null)) {
            return false
        }

        if (next == null) {
            return true
        }

        return next!!.compare(list.next)
    }
}

class MergeTwoSortedLists {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        var ptr1: ListNode? = list1
        var ptr2: ListNode? = list2

        var ptr: ListNode? = ListNode(0)
        val result: ListNode? = ptr

        while (ptr1 != null && ptr2 != null) {
            if (ptr1!!.`val` <= ptr2!!.`val`) {
                ptr?.next = ListNode(ptr1.`val`)
                ptr = ptr?.next
                ptr1 = ptr1.next
            } else {
                ptr?.next = ListNode(ptr2.`val`)
                ptr = ptr?.next
                ptr2 = ptr2.next
            }
        }

        while (ptr2 != null) {
            ptr?.next = ListNode(ptr2!!.`val`)
            ptr = ptr?.next
            ptr2 = ptr2?.next
        }

        while (ptr1 != null) {
            ptr?.next = ListNode(ptr1!!.`val`)
            ptr = ptr?.next
            ptr1 = ptr1?.next
        }

        return result!!.next
    }
}

fun main() {
    val mergeTwoSortedLists = MergeTwoSortedLists()
    check(mergeTwoSortedLists.mergeTwoLists(
        ListNode.fromList(listOf(1,2)),
        ListNode.fromList(listOf(1,2)))
        !!.compare(ListNode.fromList(listOf(1,1,2,2)))
    )

    check(mergeTwoSortedLists.mergeTwoLists(
        ListNode.fromList(listOf(-11,2,16)),
        ListNode.fromList(listOf(1,22)))
    !!.compare(ListNode.fromList(listOf(-11,1,2,16,22)))
    )

    check(mergeTwoSortedLists.mergeTwoLists(null,
        null) == null
    )

    check(mergeTwoSortedLists.mergeTwoLists(
        ListNode.fromList(listOf(-11,2,16)),
        null)
    !!.compare(ListNode.fromList(listOf(-11,2,16)))
    )

    check(mergeTwoSortedLists.mergeTwoLists(
        ListNode.fromList(listOf(1)),
        ListNode.fromList(listOf(1)))
    !!.compare(ListNode.fromList(listOf(1,1)))
    )

    println("ok")
}