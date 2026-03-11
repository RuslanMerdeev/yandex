package leetcode

import leetcode.utils.TreeNode

class SortedArrayToBinarySearchTree {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) {
            return null
        }

        return toSortedTree(nums)
    }

    private fun toSortedTree(nums: IntArray): TreeNode {
        val size = nums.size
        val middle = size/2
        val node = TreeNode(nums[middle])
        if (middle > 0) {
            node.left = toSortedTree(nums.copyOfRange(0, middle))
        }
        if (middle < size-1) {
            node.right = toSortedTree(nums.copyOfRange(middle+1, size))
        }

        return node
    }
}

fun main() {
    val solution = SortedArrayToBinarySearchTree()

    check(solution.sortedArrayToBST(intArrayOf()) == null)
    check(solution.sortedArrayToBST(intArrayOf(0))!!.compare(TreeNode(0)))
    check(solution.sortedArrayToBST(intArrayOf(0,1))!!.compare(TreeNode(1, TreeNode(0))))
    check(solution.sortedArrayToBST(intArrayOf(0,1,2))!!.compare(TreeNode(1, TreeNode(0), TreeNode(2))))
    check(solution.sortedArrayToBST(intArrayOf(0,1,2,3,4))!!.compare(TreeNode(2, TreeNode(1, TreeNode(0)), TreeNode(4,TreeNode(3)))))

    println("ok")
}
