package algorithm.dp;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 *
 Given an integer array nums, find the sum of the elements
 between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.

 * @author xiaobaoqiu  Date: 16-7-8 Time: 下午10:48
 */
public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        //0, -2, -2, 1, -4, -2, -3
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));    //1
        System.out.println(numArray.sumRange(2, 5));    //-1
        System.out.println(numArray.sumRange(0, 5));    //3
    }

    /**
     * 思路：数组s，s[i] 表示 num[0] + ... + num[i-1]
     *
     * 3 ms
     * Your runtime beats 24.54% of java submissions
     */
    public static class NumArray {
        int s[];

        public NumArray(int[] nums) {
            s = new int[nums.length + 1];
            s[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                s[i] = s[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return s[j + 1] - s[i];
        }
    }
}
