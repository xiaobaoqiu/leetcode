package algorithm.math;

import org.omg.CORBA.INTERNAL;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 click to show spoilers.

 Have you thought about this?
 Here are some good questions to ask before coding.
 Bonus points for you if you have already thought through this!

 If the integer's last digit is 0, what should the output be?
 ie, cases such as 10, 100.

 Did you notice that the reversed integer might overflow?
 Assume the input is a 32-bit integer,
 then the reverse of 1000000003 overflows.
 How should you handle such cases?

 For the purpose of this problem,
 assume that your function returns 0 when the reversed integer overflows.

 * @author xiaobaoqiu  Date: 16-7-8 Time: 下午11:45
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int cases[] = new int[] {1, 10, 100, 1001, 0, -1, -101, Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (int c : cases) {
            System.out.println(c + " -->" + reverse(c));
        }
    }

    /**
     * 2 ms
     * Your runtime beats 49.00% of java submissions.
     */
    public static int reverse(int x) {
        long v = 0;
        while (x != 0) {
            int d = x % 10;
            x /= 10;
            v = v * 10 + d;
        }
        if (v > Integer.MAX_VALUE || v < Integer.MIN_VALUE) return 0;
        return (int)v;
    }
}
