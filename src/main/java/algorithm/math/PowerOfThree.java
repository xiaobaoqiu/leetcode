package algorithm.math;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/power-of-three/
 *
 Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?

 * @author xiaobaoqiu  Date: 16-5-26 Time: 下午9:03
 */
public class PowerOfThree {
    public static void main(String[] args) {
        System.out.println((int) Math.pow(3, (int)(Math.log(Integer.MAX_VALUE)/Math.log(3.0))));
        int n = 27;
//        System.out.println(isPowerOfThree(n));
        System.out.println(isPowerOfThree_1(n));

    }

    /**
     * 循环
     * log(n)
     *
     * 20 ms
     * Your runtime beats 20.47% of java submissions
     */
    public static boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) n /= 3;
        return n == 1;
    }

    /**
     * int范围内的 3 的幂 的最大值
     * (int) Math.pow(3, (int)(Math.log(Integer.MAX_VALUE)/Math.log(3.0))) --> 1162261467
     *
     * 则 3 的幂一定是这个数的因子
     *
     * 19 ms
     * Your runtime beats 33.19% of java submissions.
     */
    public static boolean isPowerOfThree_1(int n) {
        return n > 0 && n < 1162261467 && 1162261467 % n == 0;
    }

    /**
     * 列出所有的 3的幂
     *
     * 20 ms
     * Your runtime beats 20.47% of java submissions
     */
    public static boolean isPowerOfThree_2(int n) {
        int[] allPowerOfThree = new int[]{1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467};
        return Arrays.binarySearch(allPowerOfThree, n) >= 0;
    }

    /**
     * 55 ms
     */
    public static boolean isPowerOfThree_3(int n) {
        HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467));
        return set.contains(n);
    }

    /**
     * 3进制
     *
     * 83 ms
     */
    public static boolean isPowerOfThree_4(int n) {
        return Integer.toString(n, 3).matches("10*");
    }

    /**
     * 19ms
     */
    public static boolean isPowerOfThree_5(int n) {
        switch (n) {
            case 1:
            case 3:
            case 9:
            case 27:
            case 81:
            case 243:
            case 729:
            case 2187:
            case 6561:
            case 19683:
            case 59049:
            case 177147:
            case 531441:
            case 1594323:
            case 4782969:
            case 14348907:
            case 43046721:
            case 129140163:
            case 387420489:
            case 1162261467:
                return true;
            default:
                return false;
        }
    }
}
