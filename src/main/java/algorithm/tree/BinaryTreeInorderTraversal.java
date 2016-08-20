package algorithm.tree;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?

 * @author xiaobaoqiu  Date: 16-5-25 Time: 下午9:11
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 递归
     *
     * 1 ms
     * Your runtime beats 62.04% of java submissions
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> path = new LinkedList<Integer>();
        inorder(root, path);
        return path;
    }

    private void inorder(TreeNode node, List<Integer> path) {
        if (node == null) return;

        inorder(node.left, path);
        path.add(node.val);
        inorder(node.right, path);
    }

    /**
     * 非递归，使用栈
     *
     * 2 ms
     * Your runtime beats 3.35% of java submissions.
     */
    public List<Integer> inorderTraversal_1(TreeNode root) {
        Stack<TreeNode> order = new Stack<TreeNode>();
        List<Integer> path = new LinkedList<Integer>();
        TreeNode node = root;
        while(node != null || !order.isEmpty()) {
            if (node != null) {
                order.push(node);
                node = node.left;
            }
            else {
                node = order.pop();
                path.add(node.val);
                node = node.right;
            }
        }
        return path;
    }
}
