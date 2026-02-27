package leetcode

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor(`val`: Int, left: TreeNode? = null, right: TreeNode? = null): this(`val`) {
        this.left = left
        this.right = right
    }

    fun compare(node: TreeNode): Boolean {
        if (node.`val` != this.`val`) {
            return false
        }

        if ((node.left == null) != (this.left == null)) {
            return false
        }

        if (this.left != null && !this.left!!.compare(node.left!!)) {
            return false
        }

        if ((node.right == null) != (this.right == null)) {
            return false
        }

        if (this.right != null && !this.right!!.compare(node.right!!)) {
            return false
        }

        return true
    }
}

class BinaryTreeInorderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val result = mutableListOf<Int>()

        doTraverse(root, result)

        return result
    }

    fun doTraverse(root: TreeNode, result: MutableList<Int>) {
        doLeft(root, result)
        doRoot(root, result)
        doRight(root, result)
    }

    fun doLeft(root: TreeNode, result: MutableList<Int>) {
        root.left?.also{ doTraverse(it, result) }
    }

    fun doRoot(root: TreeNode, result: MutableList<Int>) {
        result += root.`val`
    }

    fun doRight(root: TreeNode, result: MutableList<Int>) {
        root.right?.also{ doTraverse(it, result) }
    }
}


fun main() {
    val solution = BinaryTreeInorderTraversal()

    check(solution.inorderTraversal(null) == emptyList<Int>())
    check(solution.inorderTraversal(TreeNode(1)) == listOf(1))
    check(solution.inorderTraversal(TreeNode(1, null, TreeNode(2, TreeNode(3)))) == listOf(1,3,2))
    check(solution.inorderTraversal(TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5, TreeNode(6), TreeNode(7))), TreeNode(3, null, TreeNode(8,TreeNode(9))))) == listOf(4,2,6,5,7,1,3,9,8))

    println("ok")
}


//fun inorderTraversal(root: TreeNode?): List<Int> {
//    if (root == null) {
//        return emptyList()
//    }
//    var cursor = root
//
//    val result = mutableListOf<Int>()
//
//    do {
//
//    } while(cursor != null)
//
//    return result
//}
