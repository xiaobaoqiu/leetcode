package algorithm.tree;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/

 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 Subscribe to see which companies asked this question

 * @author xiaobaoqiu  Date: 16-5-17 Time: 下午9:40
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * 1 ms
     * Your runtime beats 10.20% of java submissions
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
