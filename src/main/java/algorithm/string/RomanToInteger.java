package algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 *
 Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 * @author xiaobaoqiu  Date: 16-5-25 Time: 下午9:29
 */
public class RomanToInteger {
    /**
     *
     * Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）
     *
     char* c[4][10]={
     {"","I","II","III","IV","V","VI","VII","VIII","IX"}, 1->9
     {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"}, 10->90
     {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"}, 100->900
     {"","M","MM","MMM"} 1000->3000
     };
     string roman;
     roman.append(c[3][num / 1000 % 10]);
     roman.append(c[2][num / 100 % 10]);
     roman.append(c[1][num / 10 % 10]);
     roman.append(c[0][num % 10]);
     * @param args
     */
    public static void main(String[] args) {
//        Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）
        System.out.println('A' + " --> " + (int)('A'));
        System.out.println('I' + " --> " + (int)('I'));
        System.out.println('X' + " --> " + (int)('X'));
        System.out.println('C' + " --> " + (int)('C'));
        System.out.println('M' + " --> " + (int)('M'));
        System.out.println('V' + " --> " + (int)('V'));
        System.out.println('L' + " --> " + (int)('L'));
        System.out.println('D' + " --> " + (int)('D'));
        String[] test = new String[]{
                "I", "X", "C", "M", "V", "L", "D"
//                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", //1->9
//                "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", //10->90
//                "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", //100->900
//                "M", "MM", "MMM"  //1000->3000
        };

        for (String s : test) {
            System.out.println(s + " --> " + romanToInt(s));
        }

        //"MDCCCLXXXIV"
    }

    /**
     * 规则: https://www.douban.com/note/335254352/
     *
     * 7 ms
     * Your runtime beats 82.35% of java submissions
     */
    public static int romanToInt(String s) {
        int[] map = new int[26];    //A --> 65
        map[8] = 1;         //I --> 73
        map[21] = 5;        //V --> 86
        map[23] = 10;       //X --> 88
        map[11] = 50;       //L --> 76
        map[2] = 100;       //C --> 67
        map[3] = 500;       //D --> 68
        map[12] = 1000;     //M --> 77
        if (s.length() == 1)  return map[s.charAt(0) - 65];

        int preValue = map[s.charAt(0) - 'A'];
        int sum = preValue, curValue = 0;
        for (int i = 1; i < s.length(); i++) {
            curValue = map[s.charAt(i) - 'A'];
            if (preValue < curValue) {
                sum = sum - 2 * preValue + curValue;
            } else {
                sum += curValue;
            }
            preValue = curValue;
        }
        return sum;
    }
}
