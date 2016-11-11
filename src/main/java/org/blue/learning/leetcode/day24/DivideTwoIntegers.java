package org.blue.learning.leetcode.day24;

/**
 * @author leiyi
 * @date 2016-11-11 17:19
 * @summary:DivideTwoIntegers
 */
public class DivideTwoIntegers {


    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
    }

    public static int divide(int dividend, int divisor) {
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if (ldivisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (ldividend < ldivisor) {
            return 0;
        }
        long result = 0;
        long temp;
        int i;
        boolean negative = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            negative = true;
        }
        long l = 1;
        while (ldividend >= ldivisor) {
            temp = ldivisor;
            i = 0;
            while (temp <= ldividend) {
                temp = temp << 1;
                i ++;
            }
            ldividend = ldividend - (temp >> 1);
            result = result + (l << (i - 1));
        }
        if (negative) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }
}
