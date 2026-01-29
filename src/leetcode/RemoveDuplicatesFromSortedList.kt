package leetcode

//class ListNode {
//    var next: ListNode? = null
//    var `val`: Int? = null
//
//    constructor(`val`: Int?,  next: ListNode?) {
//        this.next = next
//        this.`val` = `val`
//    }
//
//    constructor()
//
//    fun compare(node: ListNode): Boolean {
//        if (!this.equals(node)) {
//            return false
//        }
//
//        return next?.compare(node.next!!) ?: true
//    }
//
//    fun equals(node: ListNode) = `val` == node.`val` && next == node.next
//
//    fun IntArray.toListNode(): ListNode {
//        val result = ListNode()
//        val save = result
//
//        if (this.size == 0) {
//            return save
//        }
//
//        var i = 0
//        do {
//            result.`val` = this[i]
//            result
//        }
//    }
//}

class RemoveDuplicatesFromSortedList {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if(head == null) {
            return null
        }

        var cursor = head
        var prev: ListNode? = null

        do {
            if (prev != null && cursor!!.`val` == prev.`val`) {
                prev!!.next = cursor.next
            } else {
                prev = cursor
            }

            cursor = cursor!!.next
        } while(cursor != null)

        return head
    }
}

fun main() {
    val solution = RemoveDuplicatesFromSortedList()

    check(solution.deleteDuplicates(null)
    == null
    )

    check(solution.deleteDuplicates(
        ListNode.fromList(listOf(1)))
    !!.compare(ListNode.fromList(listOf(1)))
    )

    check(solution.deleteDuplicates(
        ListNode.fromList(listOf(1,1,2)))
    !!.compare(ListNode.fromList(listOf(1,2)))
    )

    check(solution.deleteDuplicates(
        ListNode.fromList(listOf(1,1,1)))
    !!.compare(ListNode.fromList(listOf(1)))
    )

    check(solution.deleteDuplicates(
        ListNode.fromList(listOf(1,1,2,3,3)))
    !!.compare(ListNode.fromList(listOf(1,2,3)))
    )

    println("ok")
}

