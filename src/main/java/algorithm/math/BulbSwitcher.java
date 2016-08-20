package algorithm.math;

/**
 * https://leetcode.com/problems/bulb-switcher/
 *
 There are n bulbs that are initially off.
 You first turn on all the bulbs.
 Then, you turn off every second bulb.
 On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
 For the ith round, you toggle every i bulb.
 For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

 Example:

 Given n = 3.

 At first, the three bulbs are [off, off, off].
 After first round, the three bulbs are [on, on, on].
 After second round, the three bulbs are [on, off, on].
 After third round, the three bulbs are [on, off, off].

 So you should return 1, because there is only one bulb is on.

 * @author xiaobaoqiu  Date: 16-5-22 Time: 下午6:40
 */
public class BulbSwitcher {
    public static void main(String[] args) {
//        int n = 2;
//        int n = 4;
//        int n = 100;
        int n = 100000000;
//        int n = Integer.MAX_VALUE - 1;
        System.out.println(bulbSwitch(n));
    }

    /**
     * 第 i 个被翻转的次数为：1~i中因子的个数，如果个数为奇数，则是打开，偶数则是关闭
     * 问题转化为 求i的因子的个数
     *
     * 其实更进一步，我们压根不需要知道具体的因子个数，我们只需要知道因子个数的奇偶性
     * 这个就很简单，完全平方数的因子个数为奇数(如100)
     *
     *
     * 这个解法是对的，结果也是对的，但是超时～～～～
     */
    public static int bulbSwitch(int n) {
        int ret = 1;
        int sqrt;
        for (int i = 2; i <= n; i++) {
            sqrt = (int)Math.sqrt(i);
            if (sqrt * sqrt == i) ret += 1;
        }
        return ret;
    }

    /**
     * 其实问题转化为求 1～n 中完全平方数的个数
     * 这个结果就是：sqrt(n)
     * 因为 1～sqrt(n) 中的每个数x，其平方都是完全平方数
     *
     * 0 ms
     * Your runtime beats 26.04% of java submissions
     */
    public static int bulbSwitch_1(int n) {
        return (int)Math.sqrt(n);
    }
}
