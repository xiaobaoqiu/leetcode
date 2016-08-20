package algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 *
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]

 * @author xiaobaoqiu  Date: 16-6-6 Time: 下午10:07
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> ret = generate(5);
        System.out.println(ret);
    }

    /**
     * 1 ms
     * Your runtime beats 40.47% of java submissions
     */
    public static List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return Collections.emptyList();

        List<List<Integer>> ret = new ArrayList<List<Integer>>(numRows);
        for (int i = 0; i < numRows; i++) {
            Integer[] temp = new Integer[i + 1];
            temp[0] = 1;
            if (i > 0) {
                temp[i] = 1;
            }
            for (int j = 1; j < i; j++) {
                temp[j] = ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j);
            }
            ret.add(Arrays.asList(temp));
        }
        return ret;
    }
}
