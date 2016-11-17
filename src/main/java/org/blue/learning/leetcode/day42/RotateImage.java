package org.blue.learning.leetcode.day42;

/**
 * @author leiyi
 * @date 2016-11-17 16:04
 * @summary:RotateImage
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 1, 2, 3}, {4, 5, 6, 7}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix.length; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * a b c d
     * e f g h
     * i j k l
     * m n o p
     * 90度旋转矩阵
     * 不能另开空间
     * 先按对角线交换
     * 再按中间交换
     * 以上矩阵 按对角线交换
     * a e i m
     * b f j n
     * c g k o
     * d h l p
     * 再以中间交换
     * m i e a
     * n j f b
     * o k g c
     * p l h d
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // 对角线交换
        for (int i = 0; i < n; i ++) {
            for (int j = i + 1; j < n; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 中间对称交换
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n / 2; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
