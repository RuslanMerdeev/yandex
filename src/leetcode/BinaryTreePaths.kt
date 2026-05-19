package leetcode

import leetcode.utils.TreeNode

class BinaryTreePaths {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val result = mutableListOf<String>()

        binaryTreePaths(root, "", result)

        return result
    }

    fun binaryTreePaths(root: TreeNode?, accumulator: String, result: MutableList<String>) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                result.add(accumulator+root.`val`)
            }

            if (root.left != null) {
                binaryTreePaths(root.left, accumulator+root.`val`+"->", result)
            }

            if (root.right != null) {
                binaryTreePaths(root.right, accumulator+root.`val`+"->", result)
            }
        }
    }
}

fun main() {
    val solution = BinaryTreePaths()

    check(solution.binaryTreePaths(null) == emptyList<String>())
    check(solution.binaryTreePaths(TreeNode(1)) == listOf("1"))
    check(solution.binaryTreePaths(TreeNode(1, TreeNode(2), TreeNode(3))) == listOf("1->2","1->3"))
    check(solution.binaryTreePaths(TreeNode(1, TreeNode(2, TreeNode(4)), TreeNode(3))) == listOf("1->2->4","1->3"))

    println("ok")
}