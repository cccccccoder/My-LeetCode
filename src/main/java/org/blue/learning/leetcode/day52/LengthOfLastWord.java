package org.blue.learning.leetcode.day52;

/**
 * Created by klein on 2016/11/22.
 */
public class LengthOfLastWord {

    public static void main(String[] args) {

    }

    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int result = 0;
        for (int i = words.length - 1; i >= 0; i --) {
            if (!"".equals(words[i].trim())) {
                return words[i].trim().length();
            }
        }
        return result;
    }
}
