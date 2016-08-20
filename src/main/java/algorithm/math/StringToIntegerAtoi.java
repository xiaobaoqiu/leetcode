package algorithm.math;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 Implement atoi to convert a string to an integer.

 * @author xiaobaoqiu  Date: 16-7-12 Time: 下午10:34
 */
public class StringToIntegerAtoi {
    public static void main(String[] args) {
        String[] cases = new String[] {
//                "123",      //123
//                "-123",     //-123
//                "00123",    //123
//                "+-2",      //0
//                "b11228552307",     //0
                "9223372036854775809", //2147483647
        };
        for (String v : cases) {
            System.out.println(v + " --> " + myAtoi(v));
        }
    }

    /**
     * trim
     * first char is digit or + or -
     * fail fast while result out of integer range
     * ignore ended invalid char
     *
     * 5 ms
     * Your runtime beats 16.48% of java submissions
     */
    public static int myAtoi(String str) {
        if (str == null || str.isEmpty()) return 0;
        str = str.trim();
        if (str.isEmpty()) return 0;

        int index = 0;
        if (str.charAt(index) < '0' && str.charAt(index) > '9' && str.charAt(index) != '+' && str.charAt(index) != '-') return 0;

        long sum = 0;
        boolean negative = false;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            if (str.charAt(index) == '-') negative = true;
            ++index;
        }
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            int d = str.charAt(index) - '0';
            sum = sum * 10 + d;
            if (!negative && sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if (negative && -sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            ++index;
        }
        if (negative) sum = -sum;
        return (int) sum;
    }
}
