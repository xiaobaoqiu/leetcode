package algorithm.string;

/**
 * https://leetcode.com/problems/reverse-string/

 Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".

 Subscribe to see which companies asked this question

 * @author xiaobaoqiu  Date: 16-5-17 Time: 下午9:03
 */
public class ReverseString {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseString(s));
    }

    /**
     * 6 ms
     */
    public static String reverseString(String s) {
        if (s == null || s.isEmpty()) return s;

        StringBuilder builder = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i-- ) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
