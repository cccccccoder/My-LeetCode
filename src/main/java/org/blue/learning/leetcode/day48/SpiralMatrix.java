package org.blue.learning.leetcode.day48;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klein on 2016/11/20.
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        List<Integer> list = spiralOrder(new int[][]{{1,2,3}, {2,3,4}});
        list.forEach(System.out::println);
    }
    /**
     *对一个矩阵
     * 顺时针绕圈输出
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 比如这个矩阵
     * 顺时针绕圈输出
     * 1 2 3 6 9 8 7 4 5
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        if (rows < 1) {
            return list;
        }
        int columns = matrix[0].length;
        int n = Math.min(rows, columns) / 2 + (Math.min(rows, columns) % 2 == 0 ? 0 : 1);

        for (int i = 0; i < n; i ++) {
            // 向右
            int index = i;
            while (index < columns - i) {
                list.add(matrix[i][index]);
                index ++;
            }
            // 向下
            index = i + 1;
            if (index >= rows -i) {
                break;
            }
            while (index < rows - i) {
                list.add(matrix[index][columns - i - 1]);
                index ++;
            }
            // 向左
            index = columns - i - 2;
            if (index < i) {
                break;
            }
            while (index >= i) {
                list.add(matrix[rows - i - 1][index]);
                index --;
            }
            // 向上
            index = rows - i - 2;
            if (index <= i) {
                break;
            }
            while (index > i) {
                list.add(matrix[index][i]);
                index --;
            }
        }
        return list;
    }
}
