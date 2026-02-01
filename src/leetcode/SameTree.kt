package leetcode

class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }

        if (p == null || q == null) {
            return false
        }

        return check(p,q)
    }

    fun check(p: TreeNode, q: TreeNode): Boolean {
        if (!checkValue(p,q)) {
            return false
        }

        if (!checkLeft(p,q)) {
            return false
        }

        if (!checkRight(p,q)) {
            return false
        }

        return true
    }

    fun checkValue(p: TreeNode, q: TreeNode): Boolean {
        return p.`val` == q.`val`
    }

    fun checkLeft(p: TreeNode, q: TreeNode): Boolean {
        if (((p.left != null) != (q.left != null))) {
            return false
        }

        if (p.left != null && !check(p.left!!, q.left!!)) {
            return false
        }

        return true
    }

    fun checkRight(p: TreeNode, q: TreeNode): Boolean {
        if (((p.right != null) != (q.right != null))) {
            return false
        }

        if (p.right != null && !check(p.right!!, q.right!!)) {
            return false
        }

        return true
    }
}

fun main() {
    val solution = SameTree()

    check(solution.isSameTree(null, null))
    check(!solution.isSameTree(null, TreeNode(1)))
    check(solution.isSameTree(TreeNode(1), TreeNode(1)))
    check(!solution.isSameTree(TreeNode(0), TreeNode(1)))
    check(solution.isSameTree(TreeNode(1, TreeNode(2), TreeNode(3)), TreeNode(1, TreeNode(2), TreeNode(3))))
    check(!solution.isSameTree(TreeNode(1, TreeNode(2)), TreeNode(1, null, TreeNode(2))))
    check(!solution.isSameTree(TreeNode(1, TreeNode(2), TreeNode(1)), TreeNode(1, TreeNode(1), TreeNode(2))))

    println("ok")
}