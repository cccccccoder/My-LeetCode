package org.blue.learning.leetcode.day33;

/**
 * @author leiyi
 * @date 2016-11-16 10:05
 * @summary:CountAndSay
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

    /**
     * 从1开始推算下去 直到n
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        String[] s = new String[n];
        s[0] = "1";
        for (int i = 1; i < n; i ++) {
            String last = s[i - 1];
            int k = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < last.length(); j ++) {
                if (j < last.length() - 1 && last.charAt(j) == last.charAt(j + 1)) {
                    k ++;
                } else {
                    sb.append(k).append(last.charAt(j));
                    s[i] = sb.toString();
                    k = 1;
                }
            }
        }
        return s[n - 1];
    }
}
