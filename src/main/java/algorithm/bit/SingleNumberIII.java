package algorithm.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number-iii/

 Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 * @author xiaobaoqiu  Date: 16-5-17 Time: 下午9:57
 */
public class SingleNumberIII {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        for (int v : nums) System.out.print(v + " , ");
        System.out.println();

//        nums = singleNumber(nums);
        nums = singleNumber_1(nums);
        for (int v : nums) System.out.print(v + " , ");
        System.out.println();
    }

    private static String toFullBinaryString(int x) {
        int[] buffer = new int[Integer.SIZE];
        for (int i = (Integer.SIZE - 1); i >= 0; i--) {
            buffer[i] = x >> i & 1;
        }
        String s = "";
        for (int j = (Integer.SIZE - 1); j >= 0; j--) {
            s = s + buffer[j];
        }
        return s;
    }

    /**
     * 思路：使用Set,不是常量的空间，最多会是 (n-2）/2 的空间
     *
     * 12 ms
     * Your runtime beats 14.33% of java submissions.
     */
    public static int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int v : nums) {
            if (set.contains(v)) set.remove(v);
            else set.add(v);
        }

        int[] ret = new int[set.size()];
        int i = 0;
        for (Integer v : set) ret[i++] = v;
        return ret;
    }

    /**
     * 思路：位运算
     * 2 ms
     * Your runtime beats 37.32% of java submissions
     *
     * 记 aXorB = a ^ b，则有 aXorB ^ a == b，而 aXorB ^ b == a
     * 所有，如果我们能将原始数据分成两组，其中一组包含a（记为数组A），另外一组包含b（记为数组B）
     * 则将 aXorB 异或 数组A中所有数据的结果 = aXorB 异或 a，即b
     * 同理，将 aXorB 异或 数组B中所有数据的结果 = aXorB 异或 b，即a
     *
     * 如何分成两组： aXorB的某一位为1，说明这个bit上 a 和 b是不相同的，通过这个bit就能达到分组的功能
     */
    public static int[] singleNumber_1(int[] nums) {
        int aXorB = 0;  //a,b为最终的两位数，aXorB为 a异或b的结果
        for (int v : nums) aXorB ^= v;

        //aXorB最高位的1，说明这个bit上，a和b是不同的，因此通过这个就可以区分出两个数组
        int lowestOneBit = Integer.lowestOneBit(aXorB);

        int[] ret = new int[]{aXorB, aXorB};
        for (int v : nums) {
            if ((v & lowestOneBit) == 0) {  //只能区分 0 和 非0
                ret[0] ^= v;
            } else {
                ret[1] ^= v;
            }
        }
        return ret;
    }
}
