package algorithm.tree;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 Invert a binary tree.

 4
 /   \
 2     7
 / \   / \
 1   3 6   9

 to

 4
 /   \
 7     2
 / \   / \
 9   6 3   1

 Trivia:
 This problem was inspired by this original tweet by Max Howell:
 Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.

 * @author xiaobaoqiu  Date: 16-5-19 Time: 下午9:46
 */
public class InvertBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * 1 ms
     * Your runtime beats 0.52% of java submissions
     */
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return root;
//        if (root.left == null && root.right == null) return root;
//
//        TreeNode newLeft = invertTree(root.right);
//        TreeNode newRight = invertTree(root.left);
//        root.left = newLeft;
//        root.right = newRight;
//        return root;
//    }


    /**
     * 0 ms
     * Your runtime beats 21.92% of java submissions
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        if(root.left != null || root.right != null) {
            TreeNode newRight = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = newRight;
        }
        return root;
    }
}
