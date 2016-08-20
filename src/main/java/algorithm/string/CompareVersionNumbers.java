package algorithm.string;

/**
 * https://leetcode.com/problems/compare-version-numbers/
 *
 Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:
 0.1 < 1.1 < 1.2 < 13.37

 * @author xiaobaoqiu  Date: 16-7-11 Time: 下午11:42
 */
public class CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));//-1
        System.out.println(compareVersion("1.1", "1")); //1
        System.out.println(compareVersion("1.0", "1")); //0
    }

    /**
     * 思路：用.切割成数组，再逐个比较
     *
     * 4 ms
     * Your runtime beats 9.96% of java submissions
     */
    public static int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");

        int i = 0;
        for (; i < v1s.length && i < v2s.length; i++) {
            int v1 = Integer.parseInt(v1s[i]);
            int v2 = Integer.parseInt(v2s[i]);
            if (v1 > v2) return 1;
            if (v1 < v2) return -1;
        }
        while (i < v1s.length) {
            int v1 = Integer.parseInt(v1s[i++]);
            if (v1 > 0) return 1;
        }
        while (i < v2s.length) {
            int v2 = Integer.parseInt(v2s[i++]);
            if (v2 > 0) return -1;
        }
        return 0;
    }
}
