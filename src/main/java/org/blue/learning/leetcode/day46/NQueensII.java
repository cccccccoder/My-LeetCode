package org.blue.learning.leetcode.day46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leiyi
 * @date 2016-11-18 15:12
 * @summary:NQueensII
 */
public class NQueensII {

    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }


    /**
     * N皇后问题，但只需要求出有几组解
     * 貌似直接用上一题的解法就好了。。
     * @param n
     * @return
     */
    public static int totalNQueens(int n) {
        List<Boolean> result = new ArrayList<>();
        char[][] chessBoard = new char[n][n];
        for (int i = 0; i < n; i ++) {
            Arrays.fill(chessBoard[i], '.');
        }
        doSolveNQueens(result, chessBoard, 0, n, 0, -1);
        return result.size();
    }

    private static void doSolveNQueens(List<Boolean> result, char[][] chessBoard, int currentRow, int n, int queenNums, int lastColumn) {
        if (currentRow >= n || queenNums == n) {
            // 找到一种解
            if (queenNums == n) {
                result.add(true);
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
            if (isValid(chessBoard, currentRow, i, n)) {
                chessBoard[currentRow][i] = 'Q';
//                oneSolution.get(currentRow).setCharAt(i, 'Q'); // 将当前位置置为皇后
                // 直接到下一行开始
                doSolveNQueens(result, chessBoard, currentRow + 1, n, queenNums + 1, i);
                // 回溯到上一层时 重置这个位置为.
                chessBoard[currentRow][i] = '.';
//                oneSolution.get(currentRow).setCharAt(i, '.');
            }
        }
    }

    private static boolean isValid(char[][] chessBoard, int currentRow, int currentColumn, int n) {
        // 检查每一列，只需检查当前行上面的，因为下面的还没填，而且上一行也不用检查
        for (int i = 0; i < currentRow - 1; i ++) {
            if (chessBoard[i][currentColumn] == 'Q') {
                return false;
            }
//            if (oneSolution.get(i).charAt(currentColumn) == 'Q') {
//                return false;
//            }
        }
        // 检查斜线 ，只需检查当前行上面的，因为下面的还没填，而且上一行也不用检查
        int r = currentRow - 2;
        int i = 2;
        while (r >= 0) {
            char[] s = chessBoard[r];
//            StringBuilder s = oneSolution.get(r);
            if ((currentColumn - i >= 0) && s[currentColumn - i] == 'Q') {
                return false;
            }
            if ((currentColumn + i < n ) && s[currentColumn + i] == 'Q') {
                return false;
            }
            r --;
            i ++;
        }
        return true;
    }
}
