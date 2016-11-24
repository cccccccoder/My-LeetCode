package org.blue.learning.leetcode.day55;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by klein on 2016/11/23.
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(20, 20));
    }

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * How many possible unique paths are there?
     * @param m
     * @param n
     * 回溯法会超时
     * 采用动态规划
     * 假设d[m][n]是 m*n个格子时的解法数
     * 推出转移方程 d[m][n] = d[m-1][n] + d[m][n-1]
     * 因为到m,n这个点的上一步，必然是m-1,n 或 m, n-1
     *
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int d[][] = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0;j < n; j ++) {
                if (i == 0 || j == 0) {
                    // 当i = 0 || j = 0时，是只有一行或者一列的情况，这时候只有一种走法
                    d[i][j] = 1;
                } else {
                    d[i][j] = d[i - 1][j] + d[i][j - 1];
                }
            }
        }
        return d[m-1][n-1];
    }

    private static void goNextPosition(int currentX, int currentY, int m, int n, List<Boolean> result) {
        if (currentX == m - 1 && currentY == n - 1) {
            result.add(true);
            return;
        }
        // 尝试向右
        if (currentY < n - 1) {
            goNextPosition(currentX, currentY + 1, m, n, result);
        }
        // 尝试向下
        if (currentX < m - 1) {
            goNextPosition(currentX + 1, currentY, m, n, result);
        }
    }
}
