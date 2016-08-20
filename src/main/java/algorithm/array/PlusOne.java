package algorithm.array;

/**
 * https://leetcode.com/problems/plus-one/
 * <p/>
 * Given a non-negative number represented as an array of digits,
 * plus one to the number.
 * <p/>
 * The digits are stored such that the most significant digit is
 * at the head of the list.
 *
 * @author xiaobaoqiu  Date: 16-6-1 Time: 下午11:06
 */
public class PlusOne {
    public static void main(String[] args) {
//        int[] digit = new int[]{9, 9, 9, 9};
        int[] digit = new int[]{9, 9, 9, 8};
        for (int v : digit) System.out.print(v + " , ");
        System.out.println();

        digit = plusOne(digit);
        for (int v : digit) System.out.print(v + " , ");
        System.out.println();
    }

    /**
     * 0 ms
     * Your runtime beats 36.50% of java submissions
     */
    public static int[] plusOne(int[] digits) {
        int more = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += more;
            more = 0;
            if (digits[i] > 9) {
                digits[i] -= 10;
                more = 1;
            }
        }
        if (more <= 0) return digits;
        int[] ret = new int[digits.length + 1];
        ret[0] = more;
        System.arraycopy(digits, 0, ret, 1, digits.length);
        return ret;
    }
}
