package leetcode

import leetcode.utils.TreeNode

class BinaryTreePreorderTraversal {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val result = mutableListOf(root.`val`)
        result.addAll(preorderTraversal(root.left))
        result.addAll(preorderTraversal(root.right))

        return result
    }
}

fun main() {
    val solution = BinaryTreePreorderTraversal()

    check(solution.preorderTraversal(null) == emptyList<Int>())
    check(solution.preorderTraversal(TreeNode(0)) == listOf(0))
    check(solution.preorderTraversal(TreeNode(0, TreeNode(1), TreeNode(2))) == listOf(0,1,2))
    check(solution.preorderTraversal(TreeNode(0, TreeNode(1, TreeNode(4)), TreeNode(2, null, TreeNode(5)))) == listOf(0,1,4,2,5))

    println("ok")
}