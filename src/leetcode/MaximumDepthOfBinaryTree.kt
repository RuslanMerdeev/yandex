package leetcode

import leetcode.utils.TreeNode
import kotlin.math.max

class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        return depth(root)
    }

    private fun depth(root: TreeNode): Int {
        return 1 + max(root.left?.let { depth(it) } ?: 0, root.right?.let { depth(it) } ?: 0)
    }
}

fun main() {
    val solution = MaximumDepthOfBinaryTree()

    check(solution.maxDepth(null) == 0)
    check(solution.maxDepth(TreeNode(0)) == 1)
    check(solution.maxDepth(TreeNode(0, TreeNode(1))) == 2)
    check(solution.maxDepth(TreeNode(0, TreeNode(1, TreeNode(2)))) == 3)
    check(solution.maxDepth(TreeNode(0, TreeNode(1, TreeNode(2),TreeNode(3)), TreeNode(4, TreeNode(5),TreeNode(6)))) == 3)

    println("ok")
}