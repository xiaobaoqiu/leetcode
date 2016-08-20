package algorithm.list;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space.
 You may not modify the values in the list, only nodes itself can be changed.
 * @author xiaobaoqiu  Date: 16-5-28 Time: 上午12:05
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printList(node1);
        ListNode head = swapPairs(node1);
        System.out.println();
        printList(head);
    }

    /**
     * 0 ms
     * Your runtime beats 13.35% of java submissions
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head, next = node.next, pre;
        head = head.next;

        while(node != null && next != null) {
            pre = node;
            node.next = next.next;
            next.next = node;

            node = node.next;
            if (node == null || node.next == null) break;
            next = node.next;
            pre.next = next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        ListNode node = head;
        while(node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
        System.out.println();
    }
}
