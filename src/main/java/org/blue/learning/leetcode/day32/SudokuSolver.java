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
        String[] array = new String[]{"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};

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
        doSolveSudoku(board, 0, 0, flag);
    }

    private static boolean doSolveSudoku(char[][] board, int i, int j, boolean[][] flag) {
        if (i > 8 || j > 8) {
            return true; // 已经解完
        }

        if (flag[i][j]) {
            // 这个位置之前就已经有值了 不能修改，进行下一格子的填写
            if (j == 8) {
                // 换行
                return doSolveSudoku(board, i + 1, 0, flag);
            } else {
                return doSolveSudoku(board, i, j + 1, flag);
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
                if (isValidSudoku(i, j, board, c)) {
                    board[i][j] = c;
                    if (j == 8) {
                        // 继续尝试下一个位置
                        if (doSolveSudoku(board, i + 1, 0, flag)) {
                            return true;
                        } else {
                            // 如果解不成功，需要将这个数字重置
                            board[i][j] = '.';
                        }
                    } else {
                        if (doSolveSudoku(board, i, j + 1, flag)) {
                            return true;
                        } else {
                            board[i][j] = '.';
                        }
                    }
                }
            }
            return false;
        }
    }

    private static boolean isValidSudoku(int i, int j, char[][] board, char c) {
        //检查九宫格的有效性
        int startRow = 3 * (i / 3);
        int startColumn = 3 * (j / 3);
        for (int m = startRow; m < startRow + 3; m ++) {
            for (int n = startColumn; n < startColumn + 3; n ++) {
                if (board[m][n] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
