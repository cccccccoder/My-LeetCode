package org.blue.learning.leetcode.day7;

/**
 * Created by klein on 2016/10/26.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        long currentTime = System.nanoTime();
        System.out.println(reverse(1563847412));
        System.out.println(System.nanoTime() - currentTime);
    }

    /**
     * 倒叙输出
     * 最简单的方法。。转换成字符串后倒叙输出
     * @param x
     * @return
     */
    public static int reverse(int x) {
        boolean isNegative = x < 0 ;
        x = Math.abs(x);
        long result = 0;
        int len = String.valueOf(x).length();
        for (int index = 0; x > 0; x /=10, index ++) {
            long i = x %10;
            for (int j = 0; j < len - index - 1; j ++) {
                i *= 10;
                if (i > Integer.MAX_VALUE) {
                    return 0;
                }
            }
            result += i;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
        }
        if (isNegative) {
            result = -result;
        }
        return (int) result;
    }
}
