package leetcode

import leetcode.utils.TreeNode

class PathSum {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) {
            return false
        }

        if (root.left == null && root.right == null) {
            return root.`val` == targetSum
        }

        if (root.left != null) {
            if (hasPathSum(root.left, targetSum-root.`val`)) {
                return true
            }
        }

        return hasPathSum(root.right, targetSum-root.`val`)
    }
}

fun main() {
    val solution = PathSum()

    check(!solution.hasPathSum(null, 0))
    check(solution.hasPathSum(TreeNode(0), 0))
    check(!solution.hasPathSum(TreeNode(0, TreeNode(2), TreeNode(3)), 0))
    check(solution.hasPathSum(TreeNode(0, TreeNode(2), TreeNode(3)), 2))
    check(solution.hasPathSum(TreeNode(0, TreeNode(2, TreeNode(4)), TreeNode(3)), 6))
    check(solution.hasPathSum(TreeNode(0, TreeNode(2, TreeNode(4)), TreeNode(3)), 3))
    check(!solution.hasPathSum(TreeNode(0, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3)), 8))

    println("ok")
}