package algorithm.list;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

 * @author xiaobaoqiu  Date: 16-5-19 Time: 下午10:15
 */
public class DeleteNodeInALinkedList {
    public static void main(String[] args) {

    }

    /**
     * 思路：将下一个节点的值复制到当前节点，然后删除下一个节点
     *
     * 1 ms
     * Your runtime beats 2.72% of java submissions
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
