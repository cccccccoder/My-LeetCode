package org.blue.learning.leetcode.day45;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leiyi
 * @date 2016-11-18 11:09
 * @summary:NQueens
 */
public class NQueens {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<List<String>> result = solveNQueens(4);
        System.out.println(System.currentTimeMillis() - start);
        for (List<String> list : result) {
            System.out.print("[");
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("]");
        }
    }

    /**
     * n皇后问题，
     * 回溯法，用递归解决
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<StringBuilder> chessBoard = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j ++) {
                row.append('.');
            }
            chessBoard.add(row);
        }
        doSolveNQueens(result, chessBoard, 0, n, 0, -1);
        return result;
    }

    private static void doSolveNQueens(List<List<String>> result, List<StringBuilder> oneSolution, int currentRow, int n, int queenNums, int lastColumn) {
        if (currentRow >= n || queenNums == n) {
            // 找到一种解
            if (queenNums == n) {
                List<String> list = new ArrayList<>();
                for (StringBuilder s : oneSolution) {
                    list.add(s.toString());
                }
                result.add(list);
            }
            return;
        }
        // 如果剩余的行数还不够剩余要填的皇后数量，说明不可能有解
        if (n - currentRow < n - queenNums) {
            return;
        }
        // 对每一行的每个位置进行尝试
        for (int i = 0; i < n; i ++) {
            // 跳过不可能的位置，与上一个位置同列或者斜线的
            if (lastColumn != -1 && (i == lastColumn || i == lastColumn - 1 || i == lastColumn + 1)) {
                continue;
            }
            if (isValid(oneSolution, currentRow, i, n)) {
                oneSolution.get(currentRow).setCharAt(i, 'Q'); // 将当前位置置为皇后
                // 直接到下一行开始
                doSolveNQueens(result, oneSolution, currentRow + 1, n, queenNums + 1, i);
                // 回溯到上一层时 重置这个位置为.
                oneSolution.get(currentRow).setCharAt(i, '.');
            }
        }
    }

    private static boolean isValid(List<StringBuilder> oneSolution, int currentRow, int currentColumn, int n) {
        // 检查每一列，只需检查当前行上面的，因为下面的还没填，而且上一行也不用检查
        for (int i = 0; i < currentRow - 1; i ++) {
            if (oneSolution.get(i).charAt(currentColumn) == 'Q') {
                return false;
            }
        }
        // 检查斜线 ，只需检查当前行上面的，因为下面的还没填，而且上一行也不用检查
        int r = currentRow - 2;
        int i = 2;
        while (r >= 0) {
            StringBuilder s = oneSolution.get(r);
            if ((currentColumn - i >= 0) && s.charAt(currentColumn - i) == 'Q') {
                return false;
            }
            if ((currentColumn + i < n ) && s.charAt(currentColumn + i) == 'Q') {
                return false;
            }
            r --;
            i ++;
        }
        return true;
    }
}
