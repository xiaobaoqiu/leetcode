package algorithm.array;

/**
 * https://leetcode.com/problems/move-zeroes/
 *
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 * @author xiaobaoqiu  Date: 16-5-17 Time: 下午9:48
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] num = new int[]{0, 1, 0, 3, 12};
        for (int v : num) System.out.print(v + " , ");
        System.out.println();

        moveZeroes(num);
        for (int v : num) System.out.print(v + " , ");
    }

    /**
     * 思路： 将非0直接放到开始,末尾补0
     *
     * 1 ms
     * Your runtime beats 23.38% of java submissions
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[cur++] = nums[i];
        }
        while (cur < nums.length) {
            nums[cur++] = 0;
        }
    }
}
