package leetcode

import leetcode.utils.TreeNode

class CountCompleteTreeNodes {

    fun countNodes(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        return 1 + countNodes(root.left) + countNodes(root.right)
    }
}

fun main() {
    val solution = CountCompleteTreeNodes()

    check(solution.countNodes(null) == 0)
    check(solution.countNodes(TreeNode(1)) == 1)
    check(solution.countNodes(TreeNode(1, TreeNode(2))) == 2)
    check(solution.countNodes(TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3, TreeNode(6)))) == 6)

    println("ok")
}