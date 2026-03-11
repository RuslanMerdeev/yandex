package leetcode.utils

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

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor(`val`: Int, left: TreeNode? = null, right: TreeNode? = null): this(`val`) {
        this.left = left
        this.right = right
    }

    fun compare(node: TreeNode): Boolean {
        if (node.`val` != this.`val`) {
            return false
        }

        if ((node.left == null) != (this.left == null)) {
            return false
        }

        if (this.left != null && !this.left!!.compare(node.left!!)) {
            return false
        }

        if ((node.right == null) != (this.right == null)) {
            return false
        }

        if (this.right != null && !this.right!!.compare(node.right!!)) {
            return false
        }

        return true
    }
}