package org.blue.learning.leetcode.day23;

/**
 * @author leiyi
 * @date 2016-11-03 10:55
 * @summary:ImplementstrStr
 */
public class ImplementstrStr {

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        int[] next = figureOutNextArray("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab");
        for (int i : next) {
            System.out.println(i);
        }
        System.out.println(strStr(s, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"));
    }

    /**
     * kmp算法
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = figureOutNextArray(needle);
        int index;
        int haystackIndex = 0;
        int result = -1;
        int temp;
        int offset = 0;
        while (haystackIndex < haystack.length()) {
            index = offset;
            temp = haystackIndex + offset;
            while (temp >= 0 && index < needle.length() && temp < haystack.length() && needle.charAt(index) == haystack.charAt(temp)) {
                index ++;
                temp ++;
            }
            if (index == needle.length()) {
                return haystackIndex;
            }
            int skip = next[index];
            if (skip <=0 ) {
                skip = 1;
                offset = 0;
            } else {
                offset = skip;
                skip = index - skip;
            }
            haystackIndex += skip;
        }
        return result;
    }

    /**
     * 求出模式串的next数组
     * next[1] 代表长度为1的模式串的最长前后缀
     * next[2] 代表长度为2的模式串的最长前后缀
     * 依次类推
     * next[0]是个特殊值
     * @return
     */
    private static int[] figureOutNextArray(String needle) {
        int[] next = new int[needle.length() + 1];
        next[0] = -1;
        next[1] = 0;
        for (int i = 1; i < needle.length(); i ++) {
            int lastK = next[i];
            if (needle.charAt(i) == needle.charAt(lastK)) {
                next[i + 1] = lastK + 1;
            } else {
                lastK = next[lastK];
                while(lastK > 0 && (needle.charAt(lastK) != needle.charAt(i))) {
                    // 利用前后缀对称，不断划分，直到最小
                    lastK = next[lastK];
                }
                next[i + 1] = lastK == -1 ? 0 : lastK;
            }
        }
        return next;
    }
}
