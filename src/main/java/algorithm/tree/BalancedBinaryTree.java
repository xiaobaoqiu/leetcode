package algorithm.tree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 *

 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree
 in which the depth of the two subtrees of every node
 never differ by more than 1.

 * @author xiaobaoqiu  Date: 16-6-1 Time: 下午10:28
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * 1 ms
     * Your runtime beats 81.84% of javas ubmissions
     */
    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    /**
     * 树的高度
     * 如果不是平衡树,就返回-1
     */
    private static int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        if (left == -1) return -1;
        int right = height(root.right);
        if (right == -1) return -1;
        if (left + 1 < right || left -1 > right) return -1;
        return Math.max(left, right) + 1;
    }
}
