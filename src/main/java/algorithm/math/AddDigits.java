package algorithm.math;

/**
 * https://leetcode.com/problems/add-digits/
 *
 Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?
 *
 * @author xiaobaoqiu  Date: 16-5-17 Time: 下午9:22
 */
public class AddDigits {
    public static void main(String[] args) {
        for(int i = 0; i< 100; i++)
            System.out.println(i + " --> " + addDigits_1(i));
    }

    /**
     * 2 ms
     * Your runtime beats 20.66% of java submissions.
     *
     * 规律:
     * 0 -> 0
     *
     * 1 -> 1
     * ...
     * 9 --> 9
     *
     * 10 -> 1
     * 11 -> 2
     * 12 -> 3
     * 13 -> 4
     * 14 -> 5
     * 15 -> 6
     * 16 -> 7
     * 17 -> 8
     * 18 -> 9
     *
     * 19 -> 1
     * 20 -> 2
     * 21 -> 3
     * ...
     * 27 -> 9
     *
     * 28 -> 1
     *
     * 即 9 为一个循环节
     */
    public static int addDigits_1(int num) {
        if (num == 0) return 0;
        int ret = num % 9;
        return (ret == 0) ? 9 : ret;
    }
}
