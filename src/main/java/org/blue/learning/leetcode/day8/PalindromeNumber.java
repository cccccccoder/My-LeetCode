package org.blue.learning.leetcode.day8;

/**
 * Created by klein on 2016/10/26.
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(3332333));
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i ++) {
            if (s.charAt(i) != s.charAt(s.length() - i -1)) {
                return false;
            }
        }
        return true;
    }
}
