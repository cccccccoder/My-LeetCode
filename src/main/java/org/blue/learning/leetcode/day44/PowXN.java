package org.blue.learning.leetcode.day44;

/**
 * @author leiyi
 * @date 2016-11-17 18:25
 * @summary:PowXN
 */
public class PowXN {

    public static void main(String[] args) {
        System.out.println(myPow(1, -2147483648));
    }

    /**
     * 将n化为二进制来看
     * 比如3^5
     * 即是3^(101) = 3^(4+0+1) = 3^4 * 3^0 * 3^1
     * 所以只要扫描n的每一位，如果这1位大于0，则让结果乘上（x^1<<i）
     * 注意到x^(1<<(i+1)) = (x^(1<<i))^2
     * 所以循环可以写成
     * for(; n>0; x*=x,n>>=1)
     * 对于n<0的情况，取-n 如果n==Integer.MIN_VALUE , 不能取-n，否则会溢出，只能先取Integer.MAX_VALUE 最后再乘以x，
     * 因为MAX_VALUE的绝对值比MIN_VALUE的绝对值小1
     * 然后用1/pow(x,n)
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0.0;
        }
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                return 1.0 / (myPow(x, n) * x);
            } else {
                n = -n;
                return 1.0 / myPow(x, n);
            }
        }
        double result = 1.0;
        // n向右移位
        //
        for(; n>0; x*=x,n>>=1) {
            // 判断最后移位是否大于0
            if ((n & 1) >0){
                result *= x;
            }
        }
        return result;
    }
}
