package algorithm.string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 *
 Given a string array words, find the maximum value of length(word[i]) * length(word[j])
 where the two words do not share common letters.
 You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

 Example 1:
 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 2:
 Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 Return 4
 The two words can be "ab", "cd".

 Example 3:
 Given ["a", "aa", "aaa", "aaaa"]
 Return 0
 No such pair of words.

 * @author xiaobaoqiu  Date: 16-5-24 Time: 下午9:12
 */
public class MaximumProductOfWordLengths {
    public static void main(String[] args) {
        String[] s = new String[] {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        System.out.println(maximumProduct(s));
    }

    /**
     * 125 ms
     * Your runtime beats 14.70% of java submissions
     */
    public static int maximumProduct(String[] words) {
        int[] dict = new int[26];
        int product = 0, iLength = 0;
        for (int i = 0; i < words.length; i++) {
            iLength = words[i].length();
            for (int j = 0; j < 26; j++) dict[j] = 0;   //Arrays.fill(dict, 0); slow
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].length() * iLength <= product || intersect(words[i], words[j], dict)) continue;
                if (words[j].length() * iLength > product) product = words[j].length() * iLength;
            }
        }
        return product;
    }

    private static boolean intersect(String left, String right, int[] dict) {
        for (int i = 0; i < left.length(); i++) {
            dict[left.charAt(i) - 'a'] = 1;
        }
        for (int i = 0; i < right.length(); i++) {
            if (dict[right.charAt(i) - 'a'] == 1) return true;
        }
        return false;
    }
}
