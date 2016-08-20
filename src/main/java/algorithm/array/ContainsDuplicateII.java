package algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 *
 Given an array of integers and an integer k,
 find out whether there are two distinct indices i and j in the array
 such that nums[i] = nums[j] and the difference between i and j is at most k.

 * @author xiaobaoqiu  Date: 16-7-4 Time: 下午10:55
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {

    }

    /**
     * 13 ms
     * Your runtime beats 48.61% of java submissions.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i< nums.length; i++) {
            Integer exist = map.get(nums[i]);
            if(exist != null && exist + k >= i) return true;
            map.put(nums[i], i);
        }

        return false;
    }
}
