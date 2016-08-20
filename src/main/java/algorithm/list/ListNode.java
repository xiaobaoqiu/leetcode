package algorithm.list;

/**
 * @author xiaobaoqiu  Date: 16-7-5 Time: 下午11:23
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public void print() {
        ListNode node = this;
        while (node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
    }
}
