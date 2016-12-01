package org.blue.learning.leetcode.day64;

/**
 * @author leiyi
 * @date 2016-12-01 16:26
 * @summary:EditDistance
 */
public class EditDistance {

    public static void main(String[] args) {
        System.out.println(minDistance("sea", "eat"));
    }

    /**
     * d[i][j] 代表word1[1-->i] 转换到word2[1-->j]需要的最小编辑数
     * 可以发现
     * d[i][0] = i;
     * d[0][j] = j;
     * if (word1[i] == word2[j]) d[i][j] = d[i-1][j-1]
     * if (word1[i] != word2[j])
     * d[i, j] = min(d[i-1, j - 1], d[i, j - 1], d[i-1, j]) + 1
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        int d[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i ++) {
            d[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j ++) {
            d[0][j] =j;
        }
        for (int i = 1; i <= word1.length(); i ++) {
            for (int j = 1; j <= word2.length(); j ++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    d[i][j] = Math.min(Math.min(d[i - 1][j], d[i][j - 1]), d[i - 1][j - 1]) + 1;
                }
            }
        }
        return d[word1.length()][word2.length()];
    }
}
