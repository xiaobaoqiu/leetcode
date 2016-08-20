package algorithm.string;

/**
 * https://leetcode.com/problems/implement-strstr/
 *
 Implement strStr().

 Returns the index of the first occurrence of needle in haystack,
 or -1 if needle is not part of haystack.
 *
 * @author xiaobaoqiu  Date: 16-7-11 Time: 下午10:26
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        String[][] cases = new String[][] {
            new String[]{"abcd", "ab"},
            new String[]{"abcd", "bc"},
            new String[]{"abcd", "cd"},
            new String[]{"abcd", "abcd"},
            new String[]{"abcd", "abcde"},
            new String[]{"abcd", ""},
            new String[]{"abcd", "abce"},
        };

        for (String[] v : cases) {
            System.out.println(v[0] + "," + v[1] + " --> " + strStr(v[0], v[1]));
        }
    }

    /**
     * 暴力
     * 时间:O(m*n)
     * 空间:O(1)
     *
     * 2 ms
     * Your runtime beats 66.79% of java submissions
     */
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (haystack.length() < needle.length()) return -1;
        if (haystack.length() == needle.length()) return haystack.equals(needle) ? 0 : -1;

        for (int i = 0; i < haystack.length() - needle.length() + 1; ) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if (j == needle.length()) return i;
            i++;
        }
        return -1;
    }

    /**
     * KMP
     * TODO
     */
    public static int strStr_1(String haystack, String needle) {
        return 0;
    }
}
