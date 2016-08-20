package algorithm.bit;

/**
 * https://leetcode.com/problems/counting-bits/

 Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].

 Follow up:

 It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 Space complexity should be O(n).
 Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

 * @author xiaobaoqiu  Date: 16-5-17 Time: 下午9:10
 */
public class CountingBits {
    public static void main(String[] args) {
        int n = 5;
        int[] ret = countBits(n);
        for (int v : ret) {
            System.out.println(v);
        }
    }

    /**
     * 5 ms
     */
    public static int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int b = 0, value = i;
            while(value != 0) {
                if((value & 1) == 1) b += 1;
                value >>= 1;
            }
            ret[i] = b;
        }

        return ret;
    }
}
