package algorithm.list;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 Reverse a singly linked list.

 * @author xiaobaoqiu  Date: 16-5-25 Time: 下午8:49
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        printList(node1);
        ListNode newHead = reverseList(node1);
        printList(newHead);
    }

    /**
     * 0 ms
     * Your runtime beats 38.64% of java submissions
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = head, cur = head.next, next = head.next.next;
        head.next = null;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;

        return cur;
    }

    private static void printList(ListNode head) {
        ListNode node = head;
        while(node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
    }
}
