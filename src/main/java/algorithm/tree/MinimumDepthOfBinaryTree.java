package algorithm.tree;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 Subscribe to see which companies asked this question

 * @author xiaobaoqiu  Date: 16-7-1 Time: 上午12:35
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        System.out.println(minDepth(node3));
    }

    /**
     * DFS + 剪枝
     *
     * 1 ms
     * Your runtime beats 10.62% of java submissions
     */
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0, Integer.MAX_VALUE);
    }

    private static int dfs(TreeNode node, int curDepth, int curMin) {
        curDepth += 1;

        //fail fast
        if (curDepth >= curMin) return curMin;

        //leaf node
        if (node.left == null && node.right == null) {
            if (curDepth < curMin) return curDepth;
        }

        if (node.left != null) {
            int leftDepth = dfs(node.left, curDepth, curMin);
            if (leftDepth < curMin) curMin = leftDepth;
        }
        if (node.right != null) {
            int rightDepth = dfs(node.right, curDepth, curMin);
            if (rightDepth < curMin) curMin = rightDepth;
        }
        return curMin;
    }
}
