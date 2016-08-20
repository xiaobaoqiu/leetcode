package algorithm.math;

/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps.
 In how many distinct ways can you climb to the top?

 * @author xiaobaoqiu  Date: 16-5-27 Time: 下午11:25
 */
public class ClimbingStairs {
    public static void main(String[] args) {

    }

    /**
     * f(1) --> 1
     * f(2) --> 2
     * f(3) --> 先走1步,剩下两步的走法就是f(2),或者先走两步,剩下的走法就是f(1)
     * ...同理
     * f(n) --> 先走1步,剩下两步的走法就是f(n-1),或者先走两步,剩下的走法就是f(n-2)
     *
     * 因此: f(n) = f(n-1) + f(n-2)
     *
     * 0 ms
     * Your runtime beats 13.04% of java submissions
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int prepre = 1, pre = 2, ret = 0;
        for (int i = 3; i<= n; i++) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }

        return ret;
    }
}
