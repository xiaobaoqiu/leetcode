package algorithm.struct;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 * <p/>
 * Implement the following operations of a stack using queues.
 * <p/>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue --
 * which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * <p/>
 * Depending on your language, queue may not be supported natively.
 * You may simulate a queue by using a list or deque (double-ended queue),
 * as long as you use only standard operations of a queue.
 * <p/>
 * You may assume that all operations are valid
 * (for example, no pop or top operations will be called on an empty stack).
 * <p/>
 * Update (2015-06-11):
 * The class name of the Java function had been updated to MyStack instead of Stack.
 *
 * @author xiaobaoqiu  Date: 16-7-1 Time: 上午12:57
 */
public class ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.top());
        stack.empty();
    }

    /**
     * 105 ms
     * Your runtime beats 87.95% of java submissions.
     */
    static class MyStack {
        private Queue<Integer> left = new LinkedList<Integer>();
        private Queue<Integer> right = new LinkedList<Integer>();
        private boolean isLeft = true;

        // Push element x onto stack.
        public void push(int x) {
            if (isLeft) left.offer(x);
            else right.offer(x);
        }

        // Removes the element on top of the stack.
        public void pop() {
            if (isLeft) {
                tranform(left, right);
                isLeft = false;
                left.poll();
            } else {
                tranform(right, left);
                isLeft = true;
                right.poll();
            }
        }

        // Get the top element.
        public int top() {
            if (isLeft) {
                tranform(left, right);
                return left.peek();
            } else {
                tranform(right, left);
                return right.peek();
            }
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return left.isEmpty() && right.isEmpty();
        }

        /**
         * tranform
         */
        private void tranform(Queue<Integer> from, Queue<Integer> to) {
            if (from.size() == 1) return;

            while (from.size() > 1) {
                to.offer(from.poll());
            }
        }
    }
}
