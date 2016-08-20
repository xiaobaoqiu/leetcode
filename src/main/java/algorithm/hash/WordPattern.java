package algorithm.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 *
 Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection
 between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters,
 and str contains lowercase letters separated by a single space

 * @author xiaobaoqiu  Date: 16-7-7 Time: 下午10:56
 */
public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog")); //true
        System.out.println(wordPattern("abba", "dog cat cat fish"));//false
        System.out.println(wordPattern("aaaa", "dog cat cat dog")); //false
        System.out.println(wordPattern("abba", "dog dog dog dog")); //false
    }

    /**
     * 2 ms
     * Your runtime beats 85.56% of java submissions.
     */
    public static boolean wordPattern(String pattern, String str) {
        String[] array = str.split(" ");
        if (pattern.length() != array.length) return false;

        int[] fMap = new int[26];
        Map<String, Integer> bMap = new HashMap<String, Integer>();
        Arrays.fill(fMap, -1);
        int pos;
        for (int i = 0; i < array.length; i++) {
            pos = pattern.charAt(i) - 'a';
            if (fMap[pos] == -1) fMap[pos] = i;
            else {
                if (!array[i].equals(array[fMap[pos]])) return false;
            }

            if (!bMap.containsKey(array[i])) bMap.put(array[i], pos);
            else {
                if (pos != bMap.get(array[i])) return false;
            }
        }

        return true;
    }
}
