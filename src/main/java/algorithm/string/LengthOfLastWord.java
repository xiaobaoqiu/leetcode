package algorithm.string;

/**
 * https://leetcode.com/problems/length-of-last-word/
 *
 Given a string s consists of upper/lower-case alphabets
 and empty space characters ' ',
 return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of
 non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.

 * @author xiaobaoqiu  Date: 16-7-7 Time: 下午11:28
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
//        String s = "Hello    World";
        String s = "Hello    World    ";
        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord_1(s));
    }

    /**
     * 2 ms
     * Your runtime beats 38.72% of java submissions.
     */
    public static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) return 0;
        String[] array = s.split(" ");
        if (array.length == 0) return 0;
        return array[array.length - 1].length();
    }

    /**
     * 自己扫描
     * 0 ms
     * Your runtime beats 56.23% of java submissions.
     */
    public static int lengthOfLastWord_1(String s) {
        if (s == null || s.isEmpty()) return 0;
        int l = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (l == 0) continue;
                else break;
            }
            l++;
        }
        return l;
    }
}
