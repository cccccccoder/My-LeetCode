package org.blue.learning.leetcode.day68;

import java.util.HashMap;

/**
 * @author leiyi
 * @date 2016-12-05 18:05
 * @summary:MinimumWindowSubstring
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {

    }

    /**
     * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
     * For example,
     * S = "ADOBECODEBANC"
     * T = "ABC"
     * Minimum window is "BANC".
     * Note:
     * If there is no such window in S that covers all characters in T, return the empty string "".
     * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> hasFound = new HashMap<>();
        HashMap<Character, Integer> needToFind = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
             hasFound.put(t.charAt(i), 0);
             if (needToFind.containsKey(t.charAt(i))) {
                needToFind.put(t.charAt(i), needToFind.get(t.charAt(i)) + 1);
             } else {
                needToFind.put(t.charAt(i), 1);
             }
        }
        int begin = 0;
        int minWindowSize = s.length();
        String retString = "";
        int count = 0;
        for (int end = 0; end < s.length(); end++) {
             Character end_c = s.charAt(end);
             if (needToFind.containsKey(end_c)) {
                 hasFound.put(end_c, hasFound.get(end_c) + 1);
                 if (hasFound.get(end_c) <= needToFind.get(end_c)) {
                            count++;
                 }
                 if (count == t.length()) {
                     while ((!needToFind.containsKey(s.charAt(begin))) || (hasFound.get(s.charAt(begin)) > needToFind.get(s.charAt(begin)))) {
                             if (needToFind.containsKey(s.charAt(begin))) {
                                 hasFound.put(s.charAt(begin), hasFound.get(s.charAt(begin)) - 1);
                             }
                            begin++;
                     }
                     if ((end - begin + 1) <= minWindowSize) {
                         minWindowSize = end - begin + 1;
                         retString = s.substring(begin, end + 1);
                     }
                 }
             }
        }

        return retString;
    }
}
