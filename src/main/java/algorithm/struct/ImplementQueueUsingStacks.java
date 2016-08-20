package algorithm.struct;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/

 Implement the following operations of a queue using stacks.

 push(x) -- Push element x to the back of queue.
 pop() -- Removes the element from in front of queue.
 peek() -- Get the front element.
 empty() -- Return whether the queue is empty.
 Notes:
 You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 * @author xiaobaoqiu  Date: 16-6-2 Time: 下午10:17
 */
public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
        queue.pop();
        queue.push(3);
        System.out.println(queue.peek());
    }

    /**
     * 134 ms
     * Your runtime beats 3.24% of java submissions
     */
    static class MyQueue {

        private Stack<Integer> in = new Stack<Integer>();
        private Stack<Integer> out = new Stack<Integer>();

        // Push element x to the back of queue.
        public void push(int x) {
            in.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            if (out.isEmpty()) {
                transfer();
            }

            out.pop();
        }

        // Get the front element.
        public int peek() {
            if (out.isEmpty()) {
                transfer();
            }

            return out.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }

        private void transfer() {
            while(!in.isEmpty()) {
                out.push(in.peek());
                in.pop();
            }
        }
    }
}
