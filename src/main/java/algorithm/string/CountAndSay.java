package algorithm.string;

/**
 * https://leetcode.com/problems/count-and-say/
 *
 The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 * @author xiaobaoqiu  Date: 16-7-12 Time: 下午9:50
 */
public class CountAndSay {
    public static void main(String[] args) {
        int n = 10;
        countAndSay(10);
    }

    /**
     * 思路：模拟
     *
     * 5 ms
     * Your runtime beats 48.34% of java submissions
     */
    public static String countAndSay(int n) {
        String s = "1";
        StringBuilder builder = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            char pre = s.charAt(0);
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == pre) ++count;
                else {
                    builder.append(count);
                    builder.append(pre);
                    pre = s.charAt(j);
                    count = 1;
                }
            }
            builder.append(count);
            builder.append(pre);

            s = builder.toString();
            builder.delete(0, builder.length());
//            System.out.println(i + " --> " + s);
        }

        return s;
    }
}
