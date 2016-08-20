package algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 https://leetcode.com/problems/binary-tree-preorder-traversal/

 Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,2,3].

 Note: Recursive solution is trivial, could you do it iteratively?

 * @author xiaobaoqiu  Date: 16-5-24 Time: 下午8:50
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode leftleft = new TreeNode(3);
        left.left = leftleft;
        root.left = left;

//        System.out.println(preorderTraversal(root));
        System.out.println(preorderTraversal_1(root));
    }

    /**
     * 递归
     * root --> left child --> right child
     *
     * 1 ms
     * Your runtime beats 56.04% of java submissions
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> path = new LinkedList<Integer>();
        preorder(root, path);
        return path;
    }

    private static void preorder(TreeNode root, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        preorder(root.left, path);
        preorder(root.right, path);
    }

    /**
     * 非递归，使用栈
     * [2,3,null,1]
     *
     * 2 ms
     * Your runtime beats 1.25% of java submissions
     */
    public static List<Integer> preorderTraversal_1(TreeNode root) {
        Stack<TreeNode> order = new Stack<TreeNode>();
        List<Integer> path = new LinkedList<Integer>();
        if (root != null) order.push(root);
        while(!order.empty()) {
            TreeNode node = order.pop();
            path.add(node.val);
            if (node.right != null) order.add(node.right);
            if (node.left != null) order.add(node.left);
        }
        return path;
    }
}
