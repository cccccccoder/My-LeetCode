package org.blue.learning.leetcode.day5;

import java.util.Arrays;

/**
 * Created by klein on 2016/10/25.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir"));
    }

    private static String longestPalindrome(String s) {

        // 暴力破解，此方法会超时 = =
//        String longestPalindromicSubstring = "";
//        if (isPalindrome(s)) {
//            return s;
//        }
//        //　循环判断每个子串是否为回文
//        int length = s.length();
//        for (int i = 0; i < length; i ++) {
//            for (int j = i + 1; j <= length; j ++) {
//                String subString = s.substring(i, j);
//                if (isPalindrome(subString) && longestPalindromicSubstring.length() < subString.length()) {
//                    longestPalindromicSubstring = subString;
//                }
//            }
//        }
//        return longestPalindromicSubstring;
        // 动态规划
        // 假设p[i][j]表示字符串的第i位至第j位的子串
        // 如果p[i][j]为回文串，那么p[i+1][j-1]一定为回文串
        // 所以可以从最小的回文串往外扩展
        boolean[][] p  = new boolean[s.length()][s.length()]; // 题目假设字符串最长为1000
        for (int i = 0; i < s.length(); i ++) {
            Arrays.fill(p[i], false); // 初始化
        }
        int start = 0;
        int maxLength = 1;
        for (int i = 0; i < s.length(); i ++) {
            p[i][i] = true;// 每单个字符串都是回文
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                p[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        for (int subLength = 3; subLength <= s.length(); subLength ++) {
            for (int startIndex = 0; startIndex <= s.length() - subLength; startIndex ++) {
                int endIndex = startIndex + subLength - 1;
                if (p[startIndex + 1][endIndex - 1] && s.charAt(startIndex) == s.charAt(endIndex)) {
                    p[startIndex][endIndex] = true;
                    maxLength = subLength;
                    start = startIndex;
                }
            }
        }
//        必须要以长度为外层循环，因为动态规划需要子问题先求解，如果长度为内循环，可能子问题还没求解，它的结果已经被使用了
//        比如第一次循环时，外层循环为0，里层循环依次从3->4->5.... 长度为4循环时需要用到长度为3的回文串的解，而长度为3的回文串还没解完
//        所以计算结果会有错误
//        for (int startIndex = 0; startIndex < s.length(); startIndex ++) {
//            for (int subLength = 3; subLength <= s.length() - startIndex; subLength ++) {
//                int endIndex = startIndex + subLength - 1;
////                System.out.println(i + "--" + endIndex)
//                if (p[startIndex + 1][endIndex - 1] && s.charAt(startIndex) == s.charAt(endIndex)) {
//                    p[startIndex][endIndex] = true;
//                    start = startIndex;
//                    maxLength = subLength;
//                }
//            }
//        }
        return s.substring(start, start + maxLength);

    }

    // 判断是否为回文字符串
    private static boolean isPalindrome(String s) {
        int length = s.length();
        if (length == 1) {
            return false;
        }
        for (int i = 0; i < length / 2; i ++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
