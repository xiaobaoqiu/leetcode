package algorithm.array;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * @author xiaobaoqiu  Date: 16-6-27 Time: 下午10:31
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3, 4, 5, 5};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int v : nums) System.out.print(v + " , ");
    }

    /**
     * 1 ms
     * Your runtime beats 51.76% of java submissions
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[pos]) {
                pos++;
                nums[pos] = nums[i];
            }
        }
        return pos + 1;
    }
}
