package org.blue.learning.leetcode.day60;

/**
 * @author leiyi
 * @date 2016-11-25 10:29
 * @summary:AddBinary
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("1", "111"));
    }

    /**
     * Given two binary strings, return their sum (also a binary string).
     * For example,
     * a = "11"
     * b = "1"
     * Return "100".
     * 逐位相加
     * 较简单的一道题
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        int digitA;
        int digitB;
        StringBuilder result = new StringBuilder();
        while (indexA >= 0 && indexB >= 0) {
            digitA = a.charAt(indexA) - '0';
            digitB = b.charAt(indexB) - '0';
            result.append((digitA + digitB + carry) % 2);
            carry = (digitA + digitB + carry) / 2;
            indexA --;
            indexB --;
        }
        while (indexA >= 0) {
            digitA = a.charAt(indexA) - '0';
            result.append((digitA + carry) % 2);
            carry = (digitA + carry) / 2;
            indexA --;
        }
        while (indexB >= 0) {
            digitB = b.charAt(indexB) - '0';
            result.append((digitB + carry) % 2);
            carry = (digitB + carry) / 2;
            indexB --;
        }
        if (carry == 1) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
