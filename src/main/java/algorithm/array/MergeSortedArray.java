package algorithm.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 *
 Given two sorted integer arrays nums1 and nums2,
 merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space
 (size that is greater or equal to m + n)
 to hold additional elements from nums2.
 The number of elements initialized in nums1 and nums2 are m and n respectively.

 * @author xiaobaoqiu  Date: 16-7-5 Time: 下午10:47
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 7, 9, 0, 0 , 0, 0};
        int[] b = new int[]{2, 4, 6, 8};
//        merge(a, 5, b, 4);
        merge_1(a, 5, b, 4);
        for (int v : a) System.out.print(v + "-->");
    }

    /**
     * 从大到小排序，只是放的位置从 m+n 开始往前
     * 1 ms
     * Your runtime beats 7.07% of java submissions
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m -= 1;
        n -= 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) nums1[i--] = nums1[m--];
            else nums1[i--] = nums2[n--];
        }
        while(m >= 0) nums1[i--] = nums1[m--];
        while(n >= 0) nums1[i--] = nums2[n--];
    }

    /**
     * 从大到小排序，只是放的位置从 m+n-1 开始往前
     * 1 ms
     * Your runtime beats 7.07% of java submissions
     */
    public static void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        --m;
        --n;
        while (m >= 0 || n >= 0) {
            if (m < 0) nums1[i--] = nums2[n--];
            else if (n < 0) nums1[i--] = nums1[m--];
            else if (nums1[m] > nums2[n]) nums1[i--] = nums1[m--];
            else nums1[i--] = nums2[n--];
        }
    }
}
