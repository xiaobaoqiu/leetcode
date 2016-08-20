package algorithm.tree;

/**
 * https://leetcode.com/problems/same-tree/
 *
 Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

 * @author xiaobaoqiu  Date: 16-5-18 Time: 下午9:19
 */
public class SameTree {
    public static void main(String[] args) {

    }

    /**
     * 0 ms
     * Your runtime beats 14.90% of java submissions.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q == null) return true;
        if (p == null || q == null) return false;

        //到这里说明 p ！= null && q ！= null
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
