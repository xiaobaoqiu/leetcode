package algorithm.list;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 *
 Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5

 * @author xiaobaoqiu  Date: 16-7-7 Time: 下午11:40
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        //1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node6 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6_1 = new ListNode(6);

//        node1.next = node2;
//        node2.next = node6;
//        node6.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6_1;
//        node1.print();
//        System.out.println();
////        ListNode head = removeElements(node1, 6);
//        ListNode head = removeElements(node6, 6);

//        node3.next = node4;
//        node4.next = node5;
//        node3.print();
//        System.out.println();
//        ListNode head = removeElements(node3, 6);

        node6.next = node6_1;
        node6.print();
        System.out.println();
        ListNode head = removeElements(node6, 6);

        if (head == null) System.out.println("null");
        else head.print();
    }

    /**
     * 1 ms
     * Your runtime beats 87.03% of java submissions
     */
    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return null;

        ListNode pre = head, node = head.next;
        while(node != null) {
            if (node.val == val) {
                pre.next = node.next;
                node = pre.next;
            } else {
                pre = node;
                node = node.next;
            }
        }
        return head;
    }
}
