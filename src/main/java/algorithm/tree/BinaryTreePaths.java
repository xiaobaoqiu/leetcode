package algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 *
 Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]

 * @author xiaobaoqiu  Date: 16-7-7 Time: 下午11:13
 */
public class BinaryTreePaths {
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

        List<String> path = binaryTreePaths(node3);
        System.out.println(path);
    }

    /**
     * 3 ms
     * Your runtime beats 28.89% of java submissions
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<String>();
        if (root != null) dfs(root, pathList, null);
        return pathList;
    }

    private static void dfs(TreeNode node, List<String> pathList, String cur) {
        if (cur == null) cur = "";
        else cur += "->";
        cur += node.val;

        if (node.left == null && node.right == null) pathList.add(cur);
        else {
            if (node.left != null) dfs(node.left, pathList, cur);
            if (node.right != null) dfs(node.right, pathList, cur);
        }
    }
}
