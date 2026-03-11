package leetcode

import leetcode.utils.TreeNode
import kotlin.math.min

class MinimumDepthOfBinaryTree {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        if (root.left == null && root.right == null) {
            return 1
        }

        if (root.left == null) {
            return minDepth(root.right)+1
        }

        if (root.right == null) {
            return minDepth(root.left)+1
        }

        return min(minDepth(root.left), minDepth(root.right))+1
    }
}

fun main() {
    val solution = MinimumDepthOfBinaryTree()

    check(solution.minDepth(null) == 0)
    check(solution.minDepth(TreeNode(0)) == 1)
    check(solution.minDepth(TreeNode(0, TreeNode(-1))) == 2)
    check(solution.minDepth(TreeNode(0, TreeNode(-1), TreeNode(1))) == 2)
    check(solution.minDepth(TreeNode(0, TreeNode(-1, TreeNode(-2)), TreeNode(1))) == 2)
    check(solution.minDepth(TreeNode(0, TreeNode(-1, TreeNode(-2, TreeNode(-3, TreeNode(-4)))))) == 5)

    //[2,null,3,null,4,null,5,null,6] == 5

    println("ok")
}