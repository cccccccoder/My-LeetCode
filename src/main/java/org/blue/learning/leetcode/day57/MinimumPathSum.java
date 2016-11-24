package org.blue.learning.leetcode.day57;

/**
 * @author leiyi
 * @date 2016-11-24 17:21
 * @summary:MinimumPathSum
 */
public class MinimumPathSum {

    public static void main(String[] args) {

    }

    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
     * which minimizes the sum of all numbers along its path.
     * Note: You can only move either down or right at any point in time.
     * 动态规划
     * 设d[i + 1][j + 1] 是移动到点（i,j）时累加的最少的和
     * 移动到点i,j时的上一步有可能是(i-1, j) 或 (i, j-1)，要使和最少，只能选择Min((i-1,j), (i, j-1))，两者间小的数
     * 那么d[i + 1][j + 1] = grid[i+1][j+1] + Math.min(d[i+1][j], d[i][j+1]);
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int d[][] = new int[m][n];
        d[0][0] = grid[0][0];
        for (int i = 1; i < m; i ++) {
            d[i][0] = d[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i ++) {
            d[0][i] = d[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                d[i][j] = grid[i][j] + Math.min(d[i - 1][j], d[i][j - 1]);
            }
        }
        return d[m - 1][n - 1];
    }
}
