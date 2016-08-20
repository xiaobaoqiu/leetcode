package algorithm.list;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists

 * @author xiaobaoqiu  Date: 16-5-27 Time: 下午11:46
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        node1.print();
        System.out.println();

        ListNode node0 = new ListNode(0);
        node0.print();
        System.out.println();

        ListNode ret = mergeTwoLists(node1, node0);
        ret.print();
    }

    /**
     * 1 ms
     * Your runtime beats 11.81% of java submissions
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null, tail = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (tail != null) tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else {
                if (tail != null) tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
            if (head == null) head = tail;
        }

        while (l1 != null) {
            tail.next = l1;
            tail = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            tail.next = l2;
            tail = l2;
            l2 = l2.next;
        }

        return head;
    }
}
