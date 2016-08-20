package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/path-sum/
 *
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 * @author xiaobaoqiu  Date: 16-6-29 Time: 下午11:16
 */
public class PathSum {
    public static void main(String[] args) {
        //[1,-2,-3,1,3,-2,null,-1]  --> 2
        TreeNode node1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(-2);
        TreeNode node_3 = new TreeNode(-3);
        TreeNode node1_1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node_2_1 = new TreeNode(-2);
        TreeNode node_1 = new TreeNode(-1);
        node1.left = node_2;
        node1.right = node_3;
        node_2.left = node1_1;
        node_2.right = node3;
        node_3.left = node_2_1;
        node1_1.left = node_1;

        System.out.println(hasPathSum(node1, 2));
    }

    /**
     * DFS
     * 1 ms
     * Your runtime beats 10.21% of java submissions
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
//        String curPath = "";
//        return dfs_debug(root, sum, 0, curPath);

        return dfs(root, sum, 0);
    }

    public static boolean dfs(TreeNode root, int expect, int curSum) {
        curSum += root.val;

        // leaf node
        if (root.left == null && root.right == null) {
            if (curSum == expect) return true;
        }
        if (root.left != null && dfs(root.left, expect, curSum)) return true;
        return root.right != null && dfs(root.right, expect, curSum);
    }

    public static boolean dfs_debug(TreeNode root, int expect, int curSum, String curPath) {
        curSum += root.val;

        // leaf node
        if (root.left == null && root.right == null) {
            System.out.println(curPath + " --> " + root.val + " = " + (curSum == expect));
            if (curSum == expect) return true;
        }
        if (root.left != null && dfs_debug(root.left, expect, curSum, curPath + "-->" + root.val)) return true;
        return root.right != null && dfs_debug(root.right, expect, curSum, curPath + "-->" + root.val);
    }
}
