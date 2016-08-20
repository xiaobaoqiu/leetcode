package algorithm.list;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * <p/>
 * Given a linked list, determine if it has a cycle in it.
 * <p/>
 * Follow up:
 * Can you solve it without using extra space?
 *
 * @author xiaobaoqiu  Date: 16-5-27 Time: 下午11:35
 */
public class LinkedListCycle {

    public static void main(String[] args) {

    }

    /**
     * 1 ms
     * Your runtime beats 9.18% of java submissions
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) return false;
            fast = fast.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
