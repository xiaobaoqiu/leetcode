package algorithm.dp;

/**
 * https://leetcode.com/problems/house-robber/
 *
 You are a professional robber planning to rob houses along a street.
 Each house has a certain amount of money stashed,
 the only constraint stopping you from robbing each of them is that
 adjacent houses have security system connected and it will
 automatically contact the police if two adjacent houses were
 broken into on the same night.

 Given a list of non-negative integers representing
 the amount of money of each house,
 determine the maximum amount of money you can rob tonight
 without alerting the police

 * @author xiaobaoqiu  Date: 16-5-28 Time: 上午12:46
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,1};
//        int[] nums = new int[]{6, 2, 5, 7, 9, 3, 1, 4, 8};
        System.out.println(rob(nums));
    }

    /**
     * DP
     * s(n)表示前n个房子能偷到的最大值
     *
     * s(n) = max(max(s(n-2), s(n-3)) + nums[n], s[n-1])
     *
     * 1 ms
     * Your runtime beats 4.35% of java submissions
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[1], nums[0] + nums[2]);

        int[] s = new int[4];
        s[0] = nums[0];
        s[1] = Math.max(nums[0], nums[1]);
        s[2] = Math.max(nums[1], nums[0] + nums[2]);

        int ret = 0;
        for (int i=3; i<nums.length; i++) {
            ret = Math.max(Math.max(s[1], s[0]) + nums[i], s[2]);
            s[0] = s[1];
            s[1] = s[2];
            s[2] = ret;
            //System.out.println(i + " --> " + ret);
        }
        return ret;
    }
}
