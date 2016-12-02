package org.blue.learning.leetcode.day65;

import java.util.Arrays;

/**
 * @author leiyi
 * @date 2016-12-01 17:48
 * @summary:SetMatrixZeroes
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
        System.out.println("================================");
        setZeroes(matrix);
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }

    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
     * 如果有一个元素为0，就将这一行和这一列都设为0
     * 不能使用额外空间
     * 利用第一行和第一列，存储是0的元素
     * 第一行和第一列要先判断是否包含0
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int column = matrix[0].length;
        if (column == 0) {
            return;
        }
        boolean firstRowContainsZero = false;
        boolean firstColumnContainsZero = false;
        // 查看第一行是否有0
        for (int i = 0; i < column; i ++) {
            if (matrix[0][i] == 0) {
                firstRowContainsZero = true;
                break;
            }
        }
        for (int[] aMatrix : matrix) {
            if (aMatrix[0] == 0) {
                firstColumnContainsZero = true;
                break;
            }
        }

        for (int i = 1; i < row; i ++) {
            for (int j = 1; j < column; j ++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < column; i ++) {
            if (matrix[0][i] == 0) {
                // 把这一列设为0
                for (int j = 1; j < row; j ++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < row; i ++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < column; j ++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstColumnContainsZero) {
            for (int i = 0; i < row; i ++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowContainsZero) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
