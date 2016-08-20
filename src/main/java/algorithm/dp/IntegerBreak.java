package algorithm.dp;

/**
 * https://leetcode.com/problems/integer-break/
 * <p/>
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 * <p/>
 * For example,
 * given n = 2, return 1 (2 = 1 + 1);
 * given n = 10, return 36 (10 = 3 + 3 + 4).
 * <p/>
 * Note: you may assume that n is not less than 2.
 *
 * @author xiaobaoqiu  Date: 16-5-23 Time: 下午11:24
 */
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(11));   //54
    }

    /**
     * DP
     * 2 3 4应该是基数
     * f(n) = max(f(n-2)*2, f(n-3)*3, f(n-4)*4)
     *
     * 0 ms
     */
    public static int integerBreak(int n) {
        //0 -> 10, 环形队列
        int[] queue = new int[]{0, 0, 1, 2, 4, 6, 9, 12, 18, 27, 36};
        if (n <= 10) return queue[n];
        int curPos = 0; //下一个写数据的下标

        int cur = 0;
        for (int i = 11; i <= n; i++) {
            cur = Math.max(Math.max(queue[(i - 2) % 11] * 2, queue[(i - 3) % 11] * 3), queue[(i - 4) % 11] * 4);
            queue[curPos] = cur;
            curPos = (curPos + 1) % 11;
        }

        return cur;
    }
}
