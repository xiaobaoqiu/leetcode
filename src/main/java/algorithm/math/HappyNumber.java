package algorithm.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 * <p/>
 * <p/>
 * Write an algorithm to determine if a number is "happy".
 * <p/>
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * <p/>
 * Example: 19 is a happy number
 * <p/>
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * @author xiaobaoqiu  Date: 16-5-27 Time: 下午10:44
 */
public class HappyNumber {
    public static void main(String[] args) {
        for (int i = 1; i< 100; i++) {
            if (isHappy(i)) System.out.println(i);
        }
    }

    /**
     * 模拟
     * 6 ms
     * Your runtime beats 26.98% of java submissions
     */
    public static boolean isHappy(int n) {
        Set<Integer> history = new HashSet<Integer>();
        while (n != 1) {
            int sum = 0, last = 0;
            while (n > 0) {
                last = n % 10;
                sum += (last * last);
                n /= 10;
            }
            n = sum;
            if(history.contains(n)) break;
            history.add(n);
        }

        return n == 1;
    }

    /**
     * https://en.wikipedia.org/wiki/Happy_number
     * 任何非 happy 的数,最终都会进到一个循环中
     *
     * 2 ms
     * Your runtime beats 84.07% of java submissions
     */
    public static boolean isHappy_1(int n) {
        int[] breaker = new int[] {4, 16, 20, 37, 42, 58, 89, 145};
        while (n != 1) {
            int sum = 0, last = 0;
            while (n > 0) {
                last = n % 10;
                sum += (last * last);
                n /= 10;
            }
            n = sum;
            if(Arrays.binarySearch(breaker, n) >= 0) break;
        }

        return n == 1;
    }
}
