package org.blue.learning.leetcode.day10;


/**
 * @author leiyi
 * @date 2016-10-27 18:52
 * @summary:LongestCommonPrefix
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"a","a","b"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        // 只需要比较最短的那个字符串和其他
        int shortestStrIndex = 0;
        for (int i = 1; i < strs.length; i ++) {
            if (strs[i].length() < strs[shortestStrIndex].length()) {
                shortestStrIndex = i;
            }
        }
        String shortestString = strs[shortestStrIndex];
        StringBuilder result = new StringBuilder(shortestString.length());
        for (int i = 0; i < shortestString.length(); i ++) {
            int hitNum = 0;
            for (int j = 0; j < strs.length; j ++) {
                if (j == shortestStrIndex) {
                    continue;
                }
                String otherString = strs[j];
                if (shortestString.charAt(i) == otherString.charAt(i)) {
                    hitNum ++;
                } else {
                    return result.toString();
                }
            }
            if (hitNum == strs.length - 1) {
                result.append(shortestString.charAt(i));
            }

        }
        return result.toString();
    }
}
