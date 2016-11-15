package org.blue.learning.leetcode.day32;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leiyi
 * @date 2016-11-15 18:01
 * @summary:SudokuSolver
 */
public class SudokuSolver {

    public static void main(String[] args) {
        String[] array = new String[]{"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"};

        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                String s = array[i];
                board[i][j] = s.charAt(j);
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        solveSudoku(board);

        System.out.println("===================================");
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 解数独
     * @param board
     */
    public static void solveSudoku(char[][] board) {
        boolean[][] flag = new boolean[9][9];
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                flag[i][j] = board[i][j] != '.';
            }
        }
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                System.out.print(flag[i][j] + " ");
            }
            System.out.println();
        }
        doSolveSudoku(board, 0, 0, flag);
    }

    private static void doSolveSudoku(char[][] board, int i, int j, boolean[][] flag) {
        if (i == 8 && j == 8) {
            return; // 已经解完
        }

        if (flag[i][j]) {
            // 这个位置之前就已经有值了 不能修改，进行下一格子的填写
            if (j == 8) {
                // 换行
                doSolveSudoku(board, i + 1, 0, flag);
            } else {
                doSolveSudoku(board, i, j + 1, flag);
            }
        } else {
            Set<Character> set = new HashSet<>();
            for (char k = '1'; k <= '9'; k ++){
                set.add(k);
            }
            // 搜集可以填的字符
            for (int m = 0; m < 9; m ++) {
                if (m != i && board[m][j] != '.' && set.contains(board[m][j])) {
                    set.remove(board[m][j]);
                }
                if (m != j && board[i][m] != '.' && set.contains(board[i][m])) {
                    set.remove(board[i][m]);
                }
            }
            for (Character c : set) {
                // 依次尝试每个字符
                board[i][j] = c;
                if (isValidSudoku(i, j, board)) {
                    if (j == 8) {
                        // 换行
                        doSolveSudoku(board, i + 1, 0, flag);
                    } else {
                        doSolveSudoku(board, i, j + 1, flag);
                    }
                }
            }
        }
    }

    private static boolean isValidSudoku(int i, int j, char[][] board) {
        //检查九宫格的有效性
        int startRow = 3 * (i / 3);
        int startColumn = 3 * (j / 3);
        Set<Character> set = new HashSet<>();
        for (int m = startRow; m < startRow + 3; m ++) {
            for (int n = startColumn; n < startColumn + 3; n ++) {
                if (board[m][n] != '.' && set.contains(board[m][n])) {
                    return false;
                } else if (board[m][n] != '.'){
                    set.add(board[m][n]);
                }
            }
        }
        return true;
    }
}
