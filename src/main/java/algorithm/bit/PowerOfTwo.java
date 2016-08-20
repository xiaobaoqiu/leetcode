package algorithm.bit;

/**
 * https://leetcode.com/problems/power-of-two/
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 * @author xiaobaoqiu  Date: 16-5-27 Time: 下午10:23
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(isPowerOfTwo(n));
    }

    /**
     * 2 ms
     * Your runtime beats 19.36% of java submissions
     */
    public static boolean isPowerOfTwo(int n) {
//        return n > 0 && (n & (n-1)) == 0;
        if (n < 1) return false;
        return (n & (n-1)) == 0;
    }
}
