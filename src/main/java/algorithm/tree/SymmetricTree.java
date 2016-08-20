package algorithm.tree;

/**
 * https://leetcode.com/problems/symmetric-tree/
 *
 Given a binary tree, check whether it is a mirror of itself
 (ie, symmetric around its center).

 For example, this binary tree is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following is not:
 1
 / \
 2   2
 \   \
 3    3
 Note:
 Bonus points if you could solve it both recursively and iteratively.
 * @author xiaobaoqiu  Date: 16-6-1 Time: 下午10:42
 */
public class SymmetricTree {
    public static void main(String[] args) {

    }

    /**
     * 1 ms
     * Your runtime beats 23.80% of java submissions
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
