package org.blue.learning.leetcode.day53;

/**
 * Created by klein on 2016/11/22.
 */
public class SpiralMatrixII {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(5);
        for (int i = 0; i < matrix.length; i ++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 顺时针生成矩阵
     * 和SpiralMatrix 类似
     * 较简单
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int times = n / 2 + (n % 2 == 0 ? 0 : 1);
        int start = 1;
        for (int i = 0; i < times; i ++) {
            // 向右
            int index = i;
            while (index < n - i) {
                matrix[i][index] = start ++;
                index ++;
            }
            // 向下
            index = i + 1;
            if (index >= n -i) {
                break;
            }
            while (index < n - i) {
                matrix[index][n - i - 1] = start ++;
                index ++;
            }
            // 向左
            index = n - i - 2;
            if (index < i) {
                break;
            }
            while (index >= i) {
                matrix[n - i - 1][index] = start ++;
                index --;
            }
            // 向上
            index = n - i - 2;
            if (index <= i) {
                break;
            }
            while (index > i) {
                matrix[index][i] = start ++;
                index --;
            }
        }
        return matrix;
    }
}
