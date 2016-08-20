package algorithm.array;

/**
 * https://leetcode.com/problems/missing-number/
 * <p/>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * <p/>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p/>
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant extra space complexity?
 *
 * @author xiaobaoqiu  Date: 16-5-23 Time: 下午11:15
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3};
        System.out.println(missingNumber(nums));
    }

    /**
     * 思路：求和，再减去数组中的每个数
     *
     * 1 ms
     * Your runtime beats 37.49% of java submissions.
     */
    public static int missingNumber(int[] nums) {
        int sum = (nums.length + 1) * nums.length / 2;
        for (int v : nums) sum -= v;
        return sum;
    }
}
