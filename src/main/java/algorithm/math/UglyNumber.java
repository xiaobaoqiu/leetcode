package algorithm.math;

/**
 * https://leetcode.com/problems/ugly-number/
 *
 Write a program to check whether a given number is an ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

 Note that 1 is typically treated as an ugly number.

 * @author xiaobaoqiu  Date: 16-5-27 Time: 下午10:39
 */
public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(17));
    }

    /**
     * 2 ms
     * Your runtime beats 17.06% of java submissions
     */
    public static boolean isUgly(int num) {
        if (num == 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }
}
