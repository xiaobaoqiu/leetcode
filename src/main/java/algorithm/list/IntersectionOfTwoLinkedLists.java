package algorithm.list;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 Write a program to find the node at which the intersection
 of two singly linked lists begins.


 For example, the following two linked lists:

 A:
      a1 → a2
              ↘
                c1 → c2 → c3
              ↗
 b1 → b2 → b3
 B:

 begin to intersect at node c1.

 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.

 * @author xiaobaoqiu  Date: 16-7-6 Time: 下午11:10
 */
public class IntersectionOfTwoLinkedLists {
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

        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node6.next = node7;
        node7.next = node4;
        node6.print();
        System.out.println();

        ListNode i = getIntersectionNode(node1, node6);
        System.out.println(i == null ? null : i.val);
    }

    /**
     * 思路：Hash存已经遍历的节点，如果是同一个节点则返回
     * 时间:O(n)
     * 空间:O(n)
     */
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        return null;
//    }

    /**
     * 思路：先得到两个链表的长度，设为 a = A.length, b = B.length,这里假设 a > b
     * 先让第一个链表先走 a-b 个节点，再开始逐步比较是否相同
     *
     * 时间:O(n)
     * 空间:O(1)
     *
     * 2 ms
     * Your runtime beats 34.83% of java submissions
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int a = 0, b = 0;
        ListNode A = headA, B = headB;
        while (A.next != null) {A = A.next; ++a;}
        while (B.next != null) {B = B.next; ++b;}

        if (a > b) {
            while(a > b) {headA = headA.next; --a;}
        } else {
            while(a < b) {headB = headB.next; --b;}
        }

        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
