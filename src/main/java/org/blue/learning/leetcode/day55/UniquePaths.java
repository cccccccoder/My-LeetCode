package org.blue.learning.leetcode.day55;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klein on 2016/11/23.
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(10, 10));
    }

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * How many possible unique paths are there?
     * @param m
     * @param n
     * 回溯法会超时
     * 还是采用动态规划
     * @return
     */
    public static int uniquePaths(int m, int n) {
        List<Boolean> result = new ArrayList<>();
        goNextPosition(0, 0, m, n, result);
        return result.size();
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
