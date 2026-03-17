package leetcode

import leetcode.utils.TreeNode

class BinaryTreePostorderTraversal {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if(root == null) {
            return emptyList()
        }

        return postorderTraversal(root.left) + postorderTraversal(root.right) + root.`val`
    }
}

fun main() {
    val solution = BinaryTreePostorderTraversal()

    check(solution.postorderTraversal(null) == emptyList<Int>())
    check(solution.postorderTraversal(TreeNode(0)) == listOf(0))
    check(solution.postorderTraversal(TreeNode(0, TreeNode(1), TreeNode(2))) == listOf(1,2,0))
    check(solution.postorderTraversal(TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5, TreeNode(6), TreeNode(7))), TreeNode(3, null,TreeNode(8, TreeNode(9))))) == listOf(4,6,7,5,2,9,8,3,1))

    println("ok")
}