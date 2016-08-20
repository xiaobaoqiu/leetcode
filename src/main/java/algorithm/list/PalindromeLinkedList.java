package algorithm.list;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 *

 Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?

 * @author xiaobaoqiu  Date: 16-7-11 Time: 下午9:56
 */
public class PalindromeLinkedList {
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

        ListNode node = findMidNode(node1);
        System.out.println(node.val);

        ListNode head = reverseList(node1);
        head.print();
    }

    /**
     * 思路：快慢指针，让快指针先到末尾，则慢指针指向中间，翻转后半个链表，再比较
     *
     * 2 ms
     * Your runtime beats 33.31% of java submissions
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        //1.find mid node
        ListNode mid = findMidNode(head);

        //2.reverse later half list
        mid = reverseList(mid);

        //3.compare
        while(mid != null) {
            if (head.val != mid.val) return false;
            head = head.next;
            mid = mid.next;
        }
        return true;
    }
    /**
     * 总数为 2n，则找到第 n + 1 个
     * 总数为 2n + 1, 则找到 n + 2
     */
    private static ListNode findMidNode(ListNode head) {
        ListNode quick = head, slow = head;
        while (true) {
            if (quick == null) break;
            if (quick.next == null) {
                quick = quick.next;
            } else {
                quick = quick.next.next;
            }
            slow = slow.next;
        }
        return slow;
    }
    private static ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next = cur.next;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;

        return cur;
    }
}
