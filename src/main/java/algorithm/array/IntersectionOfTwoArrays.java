package algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.

 * @author xiaobaoqiu  Date: 16-5-19 Time: 下午10:04
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 2, 1};
        int[] nums2 = new int[] {2, 2};

        int[] ret = intersection(nums1, nums2);
        for (int v : ret) System.out.print(v + " , ");
    }

    /**
     * 6 ms
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>(nums1.length);
        for (int v : nums1) set.add(v);

        Set<Integer> common = new HashSet<Integer>();
        for (int v : nums2) if (set.contains(v)) common.add(v);

        int[] ret = new int[common.size()];
        int i = 0;
        for (int v: common) ret[i++] = v;
        return ret;
    }
}
