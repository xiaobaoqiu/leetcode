package algorithm.bit;

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 *
 Calculate the sum of two integers a and b,
 but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.

 * @author xiaobaoqiu  Date: 16-7-12 Time: 下午10:13
 */
public class SumOfTwoIntegers {
    public static void main(String[] args) {
        getSum(1, 3);
    }

    /**
     * 思路：位运算
     *
     * 0 ms
     * Your runtime beats 7.29% of java submissions.
     */
    public static int getSum(int a, int b) {
        int carry;
        while(true) {
//            System.out.print(a + " + " + b + " --> ");
            carry = a & b;
            a = a ^ b;
//            System.out.println(a + ", carry = " + carry);
            b = carry << 1;
            if (b == 0) break;
        }
        return a;
    }
}
