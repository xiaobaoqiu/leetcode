package algorithm.tree;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * <p/>
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p/>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @author xiaobaoqiu  Date: 16-6-1 Time: 下午10:58
 */
public class BinaryTreeLevelOrderTraversal {
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

        List<List<Integer>> ret = levelOrder(node3);
        for(List<Integer> item : ret) {
            System.out.println(item);
        }
    }

    /**
     * 3 ms
     * Your runtime beats 13.20% of java submissions
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int next = 0, current = 1;
        List<Integer> cur = new LinkedList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current--;
            cur.add(node.val);

            if (node.left != null) {queue.add(node.left);next++;}
            if (node.right != null) {queue.add(node.right);next++;}
            if (current == 0) {
                ret.add(cur);
                cur = new LinkedList<Integer>();
                current = next;
                next = 0;
            }
        }
        return ret;
    }
}
