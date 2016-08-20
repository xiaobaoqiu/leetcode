package algorithm.string;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * <p/>
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p/>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p/>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 *
 * @author xiaobaoqiu  Date: 16-5-28 Time: 上午12:31
 */
public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        String i = "bcd";
//        String i = "hello";
//        String i = "leetcode";
        System.out.println(i);
        System.out.println(reverseVowels(i));
    }

    /**
     * 翻转元音字符
     *
     * 5 ms
     */
    public static String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] arr = s.toCharArray();
        for (int i=0, j=arr.length-1; i<j;) {
            while (!isVowels(arr[i]) && i<j) i++;
            while (!isVowels(arr[j]) && i<j) j--;
            if (i < j) {
                char t = arr[i];arr[i] = arr[j];arr[j]=t;
                i++;j--;
            }
        }

        return String.valueOf(arr);
    }

    private static boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
