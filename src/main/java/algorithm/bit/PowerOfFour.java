package algorithm.bit;

/**
 * https://leetcode.com/problems/power-of-four/
 *
 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example:
 Given num = 16, return true. Given num = 5, return false.

 Follow up: Could you solve it without loops/recursion?

 *
 * @author xiaobaoqiu  Date: 16-6-2 Time: 下午9:59
 */
public class PowerOfFour {
    public static void main(String[] args) {
        int num = 16;
        System.out.println(isPowerOfFour_1(num));
    }

    /**
     * 思路: log(x)/log(4)为整数
     *
     *  2 ms
     *  Your runtime beats 22.59% of java submissions
     */
    public static boolean isPowerOfFour(int num) {
        if (num <= 0) return false;

        double value = Math.log(num)/Math.log(4);
        return value - (int)value < 1e-10;
    }

    /**
     * 二进制的奇数位为1
     *
     * 2 ms
     * Your runtime beats 22.59% of java submissions
     */
    public static boolean isPowerOfFour_1(int num) {
        return num > 0 && ((num & (num - 1)) == 0) && (0x55555555 & num) != 0;
    }
}
