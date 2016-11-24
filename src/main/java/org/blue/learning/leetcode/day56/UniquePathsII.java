package org.blue.learning.leetcode.day56;

/**
 * @author leiyi
 * @date 2016-11-24 16:33
 * @summary:UniquePathsII
 */
public class UniquePathsII {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0, 1}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    /**
     * Follow up for "Unique Paths":
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * For example,
     * There is one obstacle in the middle of a 3x3 grid as illustrated below.
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     * The total number of unique paths is 2.
     * 与上一题类似
     * 但是加了障碍物，只需要将障碍物所在的点对应的d[i][j]值设为0
     * 因为不可能到达障碍物
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        int d[][] = new int[m][n];
        d[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i ++) {
            if (obstacleGrid[i][0] == 1) {
                d[i][0] = 0;
            } else {
                d[i][0] = d[i - 1][0];
            }

        }
        for (int i = 1; i < n; i ++) {
            if (obstacleGrid[0][i] == 1) {
                d[0][i] = 0;
            } else {
                d[0][i] = d[0][i - 1];
            }
        }
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                 if (obstacleGrid[i][j] == 1) {
                    d[i][j] = 0;
                } else {
                    d[i][j] = d[i - 1][j] + d[i][j - 1];
                }
            }
        }
        return d[m - 1][n - 1];
    }
}
