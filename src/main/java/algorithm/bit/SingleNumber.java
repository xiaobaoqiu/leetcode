package algorithm.bit;

/**
 * https://leetcode.com/problems/single-number/
 *
 Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 * @author xiaobaoqiu  Date: 16-5-19 Time: 下午10:00
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 2, 1, 4, 4};
        System.out.println(singleNumber(nums));
    }

    /**
     * 2 ms
     * Your runtime beats 31.74% of java submissions
     */
    public static int singleNumber(int[] nums) {
        int ret = 0;
        for (int v : nums) ret ^= v;
        return ret;
    }
}
