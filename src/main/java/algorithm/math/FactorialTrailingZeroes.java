package algorithm.math;

/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 *
 Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.

 * @author xiaobaoqiu  Date: 16-6-28 Time: 下午10:13
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(fn(n));
        System.out.println(trailingZeroes(n));

        n = 10;
        System.out.println(fn(n));
        System.out.println(trailingZeroes(n));
    }

    /**
     * 1-n 中 5 的因子个数
     * 如 6! 中 还有一个 5，则其末尾有一个 0
     *
     * 2 ms
     * Your runtime beats 4.30% of java submissions.
     */
    public static int trailingZeroes(int n) {
        int count = 0,next;
        while(n >= 5) {
            next = n/5;
            count += next;
            n = next;
        }
        return count;
    }

    public static int fn(int n) {
        int s = 1;
        while(n > 1) {
            s *= n;
            n--;
        }
        return s;
    }
}
