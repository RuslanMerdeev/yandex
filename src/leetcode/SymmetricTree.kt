package leetcode

class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        if(root == null) {
            return true
        }

        return check(root)
    }

    fun check(root: TreeNode): Boolean {
        if ((root.left != null) != (root.right != null)) {
            return false
        }

        if (root.left != null) {
            return same(root.left!!, invert(root.right!!))
        }

        return true
    }

    fun same(one: TreeNode, two: TreeNode): Boolean {
        if (!sameVal(one, two)) {
            return false
        }

        if (!sameLeft(one, two)) {
            return false
        }

        if (!sameRight(one, two)) {
            return false
        }

        return true
    }

    fun sameVal(one: TreeNode, two: TreeNode) = one.`val` == two.`val`

    fun sameLeft(one: TreeNode, two: TreeNode): Boolean {
        if ((one.left != null) != (two.left != null)) {
            return false
        }

        if(one.left == null) {
            return true
        }

        if(same(one.left!!, two.left!!)) {
            return true
        }

        return false
    }

    fun sameRight(one: TreeNode, two: TreeNode): Boolean {
        if ((one.right != null) != (two.right != null)) {
            return false
        }

        if(one.right == null) {
            return true
        }

        if(same(one.right!!, two.right!!)) {
            return true
        }

        return false
    }

    fun invert(root: TreeNode): TreeNode {
        val result = TreeNode(root.`val`)
        root.right?.also{ result.left = invert(it) }
        root.left?.also{ result.right = invert(it) }
        return result
    }
}

fun main() {
    val solution = SymmetricTree()

    check(solution.isSymmetric(null))
    check(solution.isSymmetric(TreeNode(0)))
    check(!solution.isSymmetric(TreeNode(0, TreeNode(1), TreeNode(2))))
    check(solution.isSymmetric(TreeNode(0, TreeNode(1), TreeNode(1))))
    check(solution.isSymmetric(TreeNode(1, TreeNode(2, TreeNode(3), TreeNode(4)), TreeNode(2, TreeNode(4), TreeNode(3)))))
    check(!solution.isSymmetric(TreeNode(1, TreeNode(2, null, TreeNode(3)), TreeNode(2, null, TreeNode(3)))))

    println("ok")
}