package algorithm.list;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 Given a linked list, remove the nth node from the end of list
 and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
 Given n will always be valid.
 Try to do this in one pass.

 * @author xiaobaoqiu  Date: 16-7-5 Time: 下午11:21
 */
public class RemoveNthNodeFromEndOfList {
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
        node1.print();
        System.out.println();

//        ListNode head = removeNthFromEnd(node1, 2);
        ListNode head = removeNthFromEnd_1(node1, 5);
        head.print();
        System.out.println();
    }

    /**
     * 两趟遍历的方法：先遍历获取总size，再删除第 size - n 个
     * 2 ms
     * Your runtime beats 3.79% of java submissions
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return removeNth(head, size - n + 1);
    }
    public static ListNode removeNth(ListNode head, int n) {
        if (n == 1) return head.next;
        ListNode pre = head, cur = head.next;
        while (--n > 1) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return head;
    }

    /**
     * 思路：两个指针p，q，让p先走n个节点，再一直往下走知道q到末尾，则p指向了要删除的节点
     * 1 ms
     * Your runtime beats 8.35% of java submissions
     */
    public static ListNode removeNthFromEnd_1(ListNode head, int n) {
        ListNode p = head, q = head;
        while (n-- > 0) {
            q = q.next;
        }
        if (q == null) return head.next;
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;
    }
}
