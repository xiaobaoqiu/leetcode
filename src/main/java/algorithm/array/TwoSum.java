package algorithm.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum/
 *
 Given an array of integers, return indices of the two numbers
 such that they add up to a specific target.

 You may assume that each input would have exactly one solution.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 UPDATE (2016/2/13):
 The return format had been changed to zero-based indices.
 Please read the above updated description carefully.

 * @author xiaobaoqiu  Date: 16-7-8 Time: 下午11:11
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
//        int[] ret = twoSum(nums, 17);
        int[] ret = twoSum_1(nums, 17);
        for (int v : ret) System.out.print(v + " --> ");
    }

    /**
     * 暴力
     * 时间：O(n^2)
     * 空间：O(1)
     *
     * 42 ms
     * Your runtime beats 23.73% of java submissions
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for (int i = 0; i<nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
        }
        return ret;
    }

    /**
     * 排序 + 两端搜索
     * 时间：O(nlogn + n)
     * 空间：O(n)
     *
     * 10 ms
     * Your runtime beats 38.72% of java submissions
     */
    public static int[] twoSum_1(int[] nums, int target) {
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs);

        int[] ret = new int[2];
        for (int i = 0, j = pairs.length - 1; i < j; ) {
            int t = pairs[i].value + pairs[j].value;
            if (t > target) --j;
            else if (t < target) ++i;
            else {
                ret[0] = pairs[i].index;
                ret[1] = pairs[j].index;
                break;
            }
        }
        return ret;
    }

    public static class Pair implements Comparable<Pair> {
        private int value;
        private int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }
}
