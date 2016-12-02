package org.blue.learning.leetcode.day66;

/**
 * @author leiyi
 * @date 2016-12-02 17:27
 * @summary:SearchA2DMatrix
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 51));
    }


    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * For example,
     * Consider the following matrix:
     * [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * Given target = 3, return true.
     * 矩阵每一行的第一个数字都比上一行的最后一个数字大
     * 而且每一行都是排好序的
     * 对每一行进行二分查找 判断目标是不在该行
     * 如果在该行 再做具体的二分查找
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        return binarySearchMatrix(matrix, target, 0, row - 1);
    }

    private static boolean binarySearchMatrix(int[][] matrix, int target, int startRow, int endRow) {
        if (startRow > endRow) {
            return false;
        }
        int midRow = startRow + (endRow - startRow) / 2;
        int col = matrix[midRow].length;
        if (matrix[midRow][0] == target || matrix[midRow][col - 1] == target) {
            return true;
        } else if (target > matrix[midRow][col - 1]) {
            return binarySearchMatrix(matrix, target, midRow + 1, endRow);
        } else if (target < matrix[midRow][0]) {
            return binarySearchMatrix(matrix, target, startRow, midRow - 1);
        } else {
            return binarySearchArray(matrix[midRow], target, 0, col - 1);
        }
    }

    private static boolean binarySearchArray(int[] array, int target, int left, int right) {
        if (left > right) {
            return false;
        }
        if (array[left] == target || array[right] == target) {
            return true;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            return true;
        } else if (array[mid] > target) {
            return binarySearchArray(array, target, left, mid - 1);
        } else {
            return binarySearchArray(array, target, mid + 1, right);
        }
    }
}
