package algorithm.array;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].

 Follow up:
 Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

 * @author xiaobaoqiu  Date: 16-5-18 Time: 下午9:26
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
//        int[] ret = productExceptSelf(nums);
        int[] ret = productExceptSelf_1(nums);

        for (int v : ret) System.out.print(v + " , ");
    }

    /**
     * 两个数组,A[i]存放的是 nums[i] 之前的元素的乘积,B[i]存放的是 nums[i] 之后的元素的乘积,
     * 假设结果为ret，则ret[i] = A[i] * B[i]
     *
     * 3 ms
     * Your runtime beats 11.83% of javasubmissions
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] A = new int[nums.length];
        A[0] = 1;
        int[] B = new int[nums.length];
        B[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) A[i] = A[i - 1] * nums[i - 1];
        for (int i = nums.length - 2; i >= 0; i--) B[i] = B[i + 1] * nums[i + 1];

        for (int i = 0; i < nums.length; i++) A[i] *= B[i];
        return A;
    }

    /**
     * 在上面的基础上，我们可以减少一个数组，直接再原始数据基础上修改
     * 根据题目疑似，因为输出数组不算在空间复杂度内，因此空间复杂度为常量
     *
     * 3 ms
     * Your runtime beats 11.83% of java submissions.
     */
    public static int[] productExceptSelf_1(int[] nums) {
        int[] A = new int[nums.length];
        A[0] = 1;

        for (int i = 1; i < nums.length; i++) A[i] = A[i - 1] * nums[i - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            nums[i] *= nums[i + 1];
            A[i] = A[i] * nums[i + 1];
        }

        return A;
    }

    public static int[] productExceptSelf_2(int[] nums) {
        int[] A = new int[nums.length];
        A[0] = 1;

        for (int i = 1; i < nums.length; i++) A[i] = A[i - 1] * nums[i - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            nums[i] *= nums[i + 1];
            A[i] = A[i] * nums[i + 1];
        }

        return A;
    }
}
