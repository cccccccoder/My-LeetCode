package org.blue.learning.leetcode.day43;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leiyi
 * @date 2016-11-17 17:49
 * @summary:GroupAnagrams
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for (List<String> list : result) {
            System.out.print("[");
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println("]");
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = buildkey(s);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }

    private static String buildkey(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            int index = c - 'a';
            count[index] = count[index] + 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count.length; i ++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j ++) {
                    stringBuilder.append((char) (i + 97));
                }
            }
        }
        return stringBuilder.toString();
    }

}
