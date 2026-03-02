package leetcode

import kotlin.math.abs
import kotlin.math.max

class BalancedBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        return balanced(root).second
    }

    private fun balanced(root: TreeNode): Pair<Int,Boolean> {
        val left = root.left?.let { balanced(it) } ?: Pair(0, true)
        val right = root.right?.let { balanced(it) } ?: Pair(0, true)

        return Pair(max(left.first, right.first)+1,left.second && right.second && abs(left.first-right.first) <= 1)
    }
}

fun main() {
    val solution = BalancedBinaryTree()

    check(solution.isBalanced(null))
    check(solution.isBalanced(TreeNode(0)))
    check(solution.isBalanced(TreeNode(0, TreeNode(-1))))
    check(solution.isBalanced(TreeNode(0, TreeNode(-1), TreeNode(1))))
    check(solution.isBalanced(TreeNode(0, TreeNode(-1, TreeNode(-2)), TreeNode(1))))
    check(!solution.isBalanced(TreeNode(0, TreeNode(-1, TreeNode(-2, TreeNode(-3))), TreeNode(1))))

    println("ok")
}