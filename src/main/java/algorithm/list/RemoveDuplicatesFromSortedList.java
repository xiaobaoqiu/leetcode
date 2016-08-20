package algorithm.list;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * <p/>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p/>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 * @author xiaobaoqiu  Date: 16-5-27 Time: 下午10:31
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        printList(node1);
        ListNode node = deleteDuplicates(node1);
        System.out.println();
        printList(node);
    }

    /**
     * 1 ms
     * Your runtime beats 25.39% of java submissions
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode node = head;
        while(node.next != null) {
            if (node.val == node.next.val) node.next = node.next.next;
            else node = node.next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        ListNode node = head;
        while(node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
    }
}
