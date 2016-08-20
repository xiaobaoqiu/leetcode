package algorithm.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 * <p/>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p/>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * @author xiaobaoqiu  Date: 16-5-22 Time: 上午11:24
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0};
//        int[] nums = new int[]{1, 2, 3, 1, 2, 1, 4, 1, 1};
//        int[] nums = new int[]{3, 3, 4};
//        int[] nums = new int[]{6, 6, 6, 7, 7};
        System.out.println(majorityElement(nums));
//        System.out.println(majorityElement_1(nums));
    }

    /**
     * 异或
     *
     * 3 ms
     * Your runtime beats 38.60% of java submissions
     */
    public static int majorityElement(int[] nums) {
        int candidate = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] ^ candidate) == 0) count += 1;
            else {
                count -= 1;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        return candidate;
    }

    /**
     * Hashmap
     *
     * 40 ms
     * Your runtime beats 4.62% of java submissions.
     */
    public static int majorityElement_1(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        int candidate = 0, max = 0;
        for (int v : nums) {
            if (counter.containsKey(v)) counter.put(v, counter.get(v) + 1);
            else counter.put(v, 1);

            int count = counter.get(v);
            if (count > max) {candidate = v; max = count;}
        }

        return candidate;
    }
}
