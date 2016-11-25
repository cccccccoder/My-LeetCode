package org.blue.learning.leetcode.day59;

import java.util.Arrays;

/**
 * @author leiyi
 * @date 2016-11-25 10:17
 * @summary:PlusOne
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3, 4, 5})));
    }

    public static int[] plusOne(int[] digits) {
        int temp = 1;
        for (int i = digits.length - 1; i >= 0; i --) {
            int digit = digits[i];
            digits[i] = (digit + temp) % 10;
            temp = (digit + temp) / 10;
            if (temp == 0) {
                break;
            }
        }
        if (temp == 1) {
            // 最终还有一个进位
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        } else {
            return digits;
        }
    }
}
