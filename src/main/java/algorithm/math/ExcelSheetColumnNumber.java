package algorithm.math;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 *
 Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28

 * @author xiaobaoqiu  Date: 16-5-22 Time: 上午11:19
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        String s = "AA";
        System.out.println(titleToNumber(s));
    }

    /**
     * 相当于 26 进制的数
     *
     * 2 ms
     * Your runtime beats 76.30% of java submission
     */
    public static int titleToNumber(String s) {
        int num = 0, base = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            num += (s.charAt(i) - 'A' + 1) * base;
            base *= 26;
        }
        return num;
    }
}
