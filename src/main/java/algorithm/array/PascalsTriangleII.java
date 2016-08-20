package algorithm.array;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1]

 Note:
 Could you optimize your algorithm to use only O(k) extra space?

 * @author xiaobaoqiu  Date: 16-6-28 Time: 下午10:34
 */
public class PascalsTriangleII {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(4));
        System.out.println(getRow(5));
    }

    /**
     * n 个
     * f[i][j] = f[i - 1][j - 1] + f[i - 1][j]
     *
     * 2 ms
     * Your runtime beats 75.23% of java submissions
     */
    public static List<Integer> getRow(int rowIndex) {
        Integer[] f = new Integer[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            f[0] = 1;
            if (i > 0) {
                f[i] = 1;
            }
            int pre = 1, next;
            for (int j = 1; j < i; j++) {
                next = f[j];
                f[j] = pre + f[j];
                pre = next;
            }
        }

        return Arrays.asList(f);
    }
}
