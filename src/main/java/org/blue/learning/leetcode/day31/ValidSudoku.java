package org.blue.learning.leetcode.day31;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by klein on 2016/11/14.
 */
public class ValidSudoku {

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

        System.out.println(isValidSudoku(board));
    }

    /**
     * 是否有效的数独
     * 每行每列不能有重复的数
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        // 校验每一行
        for (int i = 0; i < 9; i ++) {
            set.clear();
            for (int j = 0; j < 9; j ++) {
                if (set.contains(board[i][j])) {
                    return false;
                } else if ('.' != board[i][j]) {
                    set.add(board[i][j]);
                }
            }
        }
        // 校验每一列
        for (int i = 0; i < 9; i ++) {
            set.clear();
            for (int j = 0; j < 9; j ++) {
                if (set.contains(board[j][i])) {
                    return false;
                } else if ('.' != board[j][i]) {
                    set.add(board[j][i]);
                }
            }
        }
        // 校验每个9宫格
        for (int i = 0; i < 9; i ++) {
            int height = i / 3;
            int startRow = 3 * height;
            int startColumn = (i % 3) * 3;
            set.clear();
            for (int m = startRow; m < startRow + 3; m ++) {
                for (int n = startColumn; n < startColumn + 3; n ++) {
                    if (set.contains(board[m][n])) {
                        return false;
                    } else if ('.' != board[m][n]) {
                        set.add(board[m][n]);
                    }
                }
            }
        }
        return true;
    }
}
