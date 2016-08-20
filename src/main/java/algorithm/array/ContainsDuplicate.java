package algorithm.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 *
 Given an array of integers, find if the array contains any duplicates.
 Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

 * @author xiaobaoqiu  Date: 16-5-22 Time: 下午6:01
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4};
        //        int[] nums = new int[]{3, 3};
//        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate_1(nums));
    }

    /**
     * Hash
     *
     * 15 ms
     * Your runtime beats 32.32% of java submissions
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int v : nums) {
            if(set.contains(v)) return true;
            set.add(v);
        }

        return false;
    }

    /**
     * 排序
     *
     * 6 ms
     * Your runtime beats 81.45% of java submissions
     */
    public static boolean containsDuplicate_1(int[] nums) {
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] == nums[i]) return true;
        }
        return false;
    }
}
