package org.blue.learning.leetcode.day6;

/**
 * Created by klein on 2016/10/26.
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("A", 2));
    }

    /**
     * 比较简单的一道题，找规律
     * 1    7
     * 2  6 8
     * 3 5  9
     * 4    10
     * 所谓zigzag就是呈N字形排列
     *
     * @param s
     * @param numRows
     * @return
     */
    private static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder newString = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < numRows; i ++) {
            int pos = i;
            int gap = (numRows - 1) * 2;
            int gap1 = 0;
            if (i != 0 && i != numRows - 1) {
                gap1 = (numRows - i - 1) * 2;
            }
            int index = 0;
            while (pos < len) {
                newString.append(s.charAt(pos));
                if (i == 0 || i == numRows - 1) {
                    pos += gap;
                } else {
                    if (index % 2 == 0) {
                        pos += gap1;
                    } else {
                        pos += (gap - gap1);
                    }
                }
                index ++;
            }
        }
        return newString.toString();
    }
}
