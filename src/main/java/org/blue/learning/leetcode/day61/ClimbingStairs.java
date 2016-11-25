package org.blue.learning.leetcode.day61;

/**
 * @author leiyi
 * @date 2016-11-25 11:42
 * @summary:ClimbingStairs
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    /**
     * 动态规划
     * 假设d[n] 表示需要花费n步到达顶端的走法
     * 因为每次可以走1步或者两步
     * 则 d[n] = d[n-1] + d[n - 2]
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] d = new int[n];
        d[0] = 1;
        d[1] = 2;
        for (int i = 2; i < n; i ++) {
            d[i] = d[i - 2] + d[i - 1];
        }
        return d[n - 1];
    }

}
