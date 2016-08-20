package algorithm.bit;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 *
 Write a function that takes an unsigned integer and returns the number of ’1' bits it has
 (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
 so the function should return 3.
 * @author xiaobaoqiu  Date: 16-5-25 Time: 下午11:28
 */
public class NumberOf1Bits {
    public static void main(String[] args) {
//        int n = 11;
//        int n = -2147483648;    //1
//        int n = (int)4294967295L; //32
        int n = (int)0; //0
        System.out.println(hammingWeight(n));
    }

    /**
     * 2 ms
     * Your runtime beats 12.55% of java submissions.
     */
    public static int hammingWeight(int n) {
        long x = n;
        if (n < 0) {
            x = n & Integer.MAX_VALUE;
            x |= 0x80000000L;
        }
        int count = 0;
        while (x > 0) {
            if ((x ^ (x-1)) == 1) count++;
            x >>= 1;
        }
        return count;
    }
}
