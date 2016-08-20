package algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 *
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character
 while preserving the order of characters.
 No two characters may map to the same character
 but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 * @author xiaobaoqiu  Date: 16-7-4 Time: 下午11:06
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic_1("egg", "add"));   //true
        System.out.println(isIsomorphic_1("foo", "bar"));   //false
        System.out.println(isIsomorphic_1("paper", "title"));   //true
        System.out.println(isIsomorphic_1("ab", "aa")); //false
        System.out.println(isIsomorphic_1("ab", "ca")); //true
    }

    /**
     * 34 ms
     * Your runtime beats 26.59% of java submissions
     */
    public static boolean isIsomorphic(String s, String t) {
        if ((s == null && t == null)) return true;
        if ((s == null || t == null)) return false;
        if (s.isEmpty() && t.isEmpty()) return true;
        if (s.length() != t.length()) return false;
        
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (t.charAt(i) != map.get(s.charAt(i))) return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        map.clear();
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                if (s.charAt(i) != map.get(t.charAt(i))) return false;
            } else {
                map.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }

    /**
     * 48 ms
     * Your runtime beats 12.76% of java submissions
     */
    public static boolean isIsomorphic_1(String s, String t) {
        if ((s == null && t == null)) return true;
        if ((s == null || t == null)) return false;
        if (s.isEmpty() && t.isEmpty()) return true;
        if (s.length() != t.length()) return false;

        Map<Character, Character> fMap = new HashMap<Character, Character>();
        Map<Character, Character> bMap = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (fMap.containsKey(s.charAt(i))) {
                if (t.charAt(i) != fMap.get(s.charAt(i))) return false;
            } else {
                fMap.put(s.charAt(i), t.charAt(i));
            }

            if (bMap.containsKey(t.charAt(i))) {
                if (s.charAt(i) != bMap.get(t.charAt(i))) return false;
            } else {
                bMap.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
