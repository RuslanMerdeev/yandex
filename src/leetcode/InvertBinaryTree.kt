package leetcode

import leetcode.utils.TreeNode

class InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        val left = invertTree(root.left)
        root.left = invertTree(root.right)
        root.right = left

        return root
    }
}

fun main() {
    val solution = InvertBinaryTree()

    check(solution.invertTree(null) == null)
    check(solution.invertTree(TreeNode(0))!!.compare(TreeNode(0)))
    check(solution.invertTree(TreeNode(0, TreeNode(1)))!!.compare(TreeNode(0, null, TreeNode(1))))
    check(solution.invertTree(TreeNode(0, TreeNode(1), TreeNode(2)))!!.compare(TreeNode(0, TreeNode(2), TreeNode(1))))

    println("ok")
}