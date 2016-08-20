package algorithm.math;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 *
 Given a positive integer,
 return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB

 * @author xiaobaoqiu  Date: 16-7-11 Time: 下午11:16
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        int[] cases = new int[] {1, 2, 25, 26, 27, 28};
        for (int v : cases) {
            System.out.println(v + " --> " + convertToTitle(v));
        }
    }

    /**
     * 思路：26进制
     * 1 --> A
     * 2 --> B
     * 26 --> Z
     *
     * 0 ms
     * Your runtime beats 9.50% of java submissions
     */
    public static String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        do {
            builder.append((char) ('A' + ((n - 1) % 26)));
            n = (n - 1) / 26;
        } while (n > 0);
        return builder.reverse().toString();
    }
}
