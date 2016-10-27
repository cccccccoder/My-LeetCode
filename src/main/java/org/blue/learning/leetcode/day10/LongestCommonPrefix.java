package org.blue.learning.leetcode.day10;


/**
 * @author leiyi
 * @date 2016-10-27 18:52
 * @summary:LongestCommonPrefix
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"aaa", "bbb", "ccc"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int index = 0;
        int xorResult;
        StringBuilder result = new StringBuilder();
        while(true) {
            xorResult = -1;
            for (String s : strs) {
                if (index < s.length()) {
                    if (xorResult == -1) {
                        xorResult = s.charAt(index);
                    } else {
                        xorResult = xorResult ^ s.charAt(index);
                    }
                } else {
                    return result.toString();
                }
            }
            if (xorResult == 0) {
                return result.toString();
            }
            result.append(strs[0].charAt(index));
            index ++;
        }
    }
}
