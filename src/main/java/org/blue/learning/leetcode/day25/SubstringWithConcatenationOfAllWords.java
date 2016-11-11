package org.blue.learning.leetcode.day25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leiyi
 * @date 2016-11-11 18:01
 * @summary:SubstringWithConcatenationOfAllWords
 */
public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        List<Integer> list = findSubstring("barfoothefoobarman", new String[] {"foo", "bar"});
        for (Integer i : list) {
            System.out.println(i);
        }
    }
    /**
     * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
     * For example, given:
     * s: "barfoothefoobarman"
     * words: ["foo", "bar"]
     * You should return the indices: [0,9].
     * (order does not matter).
     * @param s
     * @param words
     * @return
     * 所有的word长度一致，可看做一个字符
     * 用一个map存储所有word，以word为key,value为这个word出现的次数
     * 遍历s，每次取word长度的字符串去看map里是否存在，存在则count - 1，为0的时候移除这个key，直到map为空
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        int wordLen = words[0].length();
        if (wordLen * words.length > s.length()) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            map.put(word, map.get(word) + 1);
        }
        String sub;
        for (int i = 0; i <= s.length() - wordLen * words.length; i ++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                sub = s.substring(j, j + wordLen);
                if (copy.containsKey(sub)) {
                    if (copy.get(sub) == 1) {
                        copy.remove(sub);
                        if (copy.isEmpty()) {
                            result.add(i);
                            break;
                        }
                    } else {
                        copy.put(sub, copy.get(sub) - 1);
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
