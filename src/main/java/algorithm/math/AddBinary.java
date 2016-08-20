package algorithm.math;

/**
 * https://leetcode.com/problems/add-binary/
 *
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".

 * @author xiaobaoqiu  Date: 16-7-8 Time: 下午10:23
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(addBinary(a, b));    //10101
    }

    /**
     * 3 ms
     * Your runtime beats 89.98% of java submissions
     */
    public static String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0, temp;
        for (; i >= 0 && j >= 0; i--, j--) {
            temp = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            carry = 0;
            if (temp >= 2) {carry = 1;temp -= 2;}
            builder.append((char)(temp + '0'));
        }
        while (i >= 0) {
            temp = a.charAt(i--) - '0' + carry;
            carry = 0;
            if (temp >= 2) {carry = 1;temp -= 2;}
            builder.append((char)(temp + '0'));
        }
        while (j >= 0) {
            temp = b.charAt(j--) - '0' + carry;
            carry = 0;
            if (temp >= 2) {carry = 1;temp -= 2;}
            builder.append((char)(temp + '0'));
        }
        if (carry == 1) builder.append('1');
        return builder.reverse().toString();
    }
}
