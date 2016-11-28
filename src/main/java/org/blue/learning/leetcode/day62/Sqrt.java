package org.blue.learning.leetcode.day62;

/**
 * @author leiyi
 * @date 2016-11-28 11:28
 * @summary:Sqrt
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(7));
    }

    /**
     * 求解平方根
     * 二分查找法，一个数的平方根一定在1--- x / 2 之间，2分查找 逼近结果
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x <=1 ) {
            return x;
        }
        int low = 1;
        int high = x / 2;
        int mid;
        while (low <= high) {
            mid = low + (high - low)  / 2;
            long temp = mid * mid;
            if (temp == x) {
                return mid;
            } else if (temp > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
