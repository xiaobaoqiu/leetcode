package algorithm.array;

/**
 * https://leetcode.com/problems/rotate-array/
 *
 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3,
 the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can,
 there are at least 3 different ways to solve this problem.

 * @author xiaobaoqiu  Date: 16-7-8 Time: 下午11:56
 */
public class RotateArray {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,4,5,6,7};
//        int k = 3;
        int[] nums = new int[]{1,2,3,4,5,6};
        int k = 2;
        for (int v : nums) System.out.print(v + " --> ");
        System.out.println();
//        rotate(nums, k);
//        rotate_1(nums, k);
        rotate_2(nums, k);
        for (int v : nums) System.out.print(v + " --> ");
        System.out.println();
    }

    /**
     * 新开一个数组
     * 时间:O(n)
     * 空间:O(1)
     *
     * 1 ms
     * Your runtime beats 13.71% of java submissions.
     */
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;

        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int pos = i + k;
            if (pos >= nums.length) pos -= nums.length;
            temp[pos] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    /**
     * 模拟一个一个移动
     */
    public static void rotate_1(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        //i don't want to do it
    }

    /**
     * 两部分翻转
     * (1).翻转后 k 个
     * (2).翻转前 n-k 个
     * (3).翻转全部
     *
     * 时间:O(n)
     * 空间:O(1)
     *
     * 1 ms
     * Your runtime beats 13.27% of javasubmissions
     */
    public static void rotate_2(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;

        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    private static void reverse(int[] nums, int beg, int end) {
        if (beg >= end) return;
        int temp;
        for (int i = beg, j = end; i < j; i++, j--) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
