package algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to num2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 * @author xiaobaoqiu  Date: 16-5-19 Time: 下午10:04
 */
public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
//        int[] nums1 = new int[] {1, 2, 2, 1};
//        int[] nums2 = new int[] {2, 2};

        int[] nums1 = new int[] {2};
        int[] nums2 = new int[] {2, 2};

        int[] ret = intersection(nums1, nums2);
        for (int v : ret) System.out.print(v + " , ");
    }

    /**
     * 13 ms
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int v : nums1) {
            if (!map.containsKey(v)) map.put(v, 1);
            else map.put(v, map.get(v) + 1);
        }

        int total = 0;
        Map<Integer, Integer> common = new HashMap<Integer, Integer>();;
        for (int v : nums2) {
            if (map.containsKey(v)) {
                int count = map.get(v);
                Integer cur = common.get(v);
                if (cur == null || cur == 0) {common.put(v, 1); total += 1;}
                else if (cur < count) {common.put(v, common.get(v) + 1); total += 1;}
            }
        }

        int[] ret = new int[total];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : common.entrySet()) {
            for (int j = 0; j < e.getValue(); j++) ret[i++] = e.getKey();
        }
        return ret;
    }
}
