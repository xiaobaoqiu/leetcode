package algorithm.math;

/**
 * https://leetcode.com/problems/palindrome-number/
 *
 Determine whether an integer is a palindrome. Do this without extra space.

 click to show spoilers.

 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.

 * @author xiaobaoqiu  Date: 16-6-28 Time: 下午10:51
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println((int)Math.log10(101));
        int x = 654321;
//        System.out.println(isPalindrome_1(x));
//        x = 1;
//        System.out.println(isPalindrome_1(x));
//        x = 101;
//        System.out.println(isPalindrome_1(x));
//        x = 1000021;
//        System.out.println(isPalindrome_1(x));
//        x = 10;
//        System.out.println(isPalindrome_1(x));
        x = 121;
        System.out.println(isPalindrome_1(x));
    }

    /**
     * 15 ms
     * Your runtime beats 21.84% of java submissions.
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int i = 0, j = (int) Math.log10(x);
        int iBase = 1, jBase = (int)Math.pow(10, j);
        while( i < j) {
            //i-th dight
            int iDight = (x / iBase) % 10;

            //j-th dight
            int jDight = (x / jBase) % 10;

            if (iDight != jDight) return false;

            i++;
            j--;
            iBase *= 10;
            jBase /= 10;
        }
        return true;
    }

    /**
     * 构造 高半部分 和 低半部分
     *
     * 11 ms
     * Your runtime beats 76.50% of java submissions
     */
    public static boolean isPalindrome_1(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x < 100) return x % 11 == 0;
        if (x % 10 == 0) return false;

        int low = 0;
        while (x > low) {
            low = low * 10 + x % 10;
            x /= 10;
        }
        return (x == low) || (x == low / 10);
    }
}
