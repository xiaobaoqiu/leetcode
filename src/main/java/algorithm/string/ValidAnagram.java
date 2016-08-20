package algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/
 *
 Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 * @author xiaobaoqiu  Date: 16-5-22 Time: 下午5:13
 */
public class ValidAnagram {
    public static void main(String[] args) {
        //题目意思：字母出现次数相同
        String s = "anagram";
        String t = "nagaram";

//        String s = "rat";
//        String t = "car";

        System.out.println(isAnagram_1(s, t));
    }

    /**
     * 45 ms
     * Your runtime beats 20.90% of java submissions
     */
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> sCount = new HashMap<Character, Integer>();
        for (int i = 0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if (!sCount.containsKey(c)) sCount.put(c, 1);
            else sCount.put(c, sCount.get(c) + 1);
        }

        Map<Character, Integer> tCount = new HashMap<Character, Integer>();
        for (int i = 0; i<t.length(); i++) {
            Character c = t.charAt(i);
            if (!tCount.containsKey(c)) tCount.put(c, 1);
            else tCount.put(c, tCount.get(c) + 1);
        }

        for (Map.Entry<Character, Integer> e : sCount.entrySet()) {
            if (!e.getValue().equals(tCount.get(e.getKey()))) return false;
        }
        for (Map.Entry<Character, Integer> e : tCount.entrySet()) {
            if (!e.getValue().equals(sCount.get(e.getKey()))) return false;
        }
        return true;
    }

    /**
     * 排序
     *
     * 8 ms
     * Your runtime beats 46.36% of java submissions
     */
    public static boolean isAnagram_1(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for (int i = 0; i < s.length(); i++) {
            if (sArray[i] != tArray[i]) return false;
        }

        return true;
    }
}
