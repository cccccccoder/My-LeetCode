package org.blue.learning.leetcode.day71;

import java.util.Arrays;

/**
 * @author leiyi
 * @date 2016-12-27 17:40
 * @summary:WordSearch
 */
public class WordSearch {

    public static void main(String[] args) {
//        char[][] borad = new char[][] {
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };
                char[][] borad = new char[][] {
                        {'a', 'a', 'a', 'a'},
                        {'a', 'a', 'a', 'a'},
                        {'a', 'a', 'a', 'a'}
        };
        System.out.println(exist(borad, "aaaaaaaaaaaaa"));
        System.out.println(exist(borad, "SEE"));
        System.out.println(exist(borad, "ABCB"));
    }

    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
     * For example,
     * Given board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * word = "ABCCED", -> returns true,
     * word = "SEE", -> returns true,
     * word = "ABCB", -> returns false.
     * 回溯法，相当于查找到给定字符串的一条路径
     * 可以上下左右移动
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < visited.length; i ++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j++) {
                visited[i][j] = true;
                if (searchWord(word, 0, board, i, j, visited)) {
                    return true;
                }
                visited[i][j] = false;
            }
        }
        return false;
    }

    private static boolean searchWord(String target, int targetPos, char[][] board, int currentX, int currentY, boolean[][] visited) {
        if (targetPos == target.length()) {
            return true;
        }
        if (board[currentX][currentY] == target.charAt(targetPos) && targetPos == target.length() - 1) {
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        if (board[currentX][currentY] == target.charAt(targetPos)) {

            // 继续向周围四个方向探索，但不能往回走
            // 上 X - 1
            if (currentX - 1 >= 0 && !visited[currentX - 1][currentY]) {
                visited[currentX - 1][currentY] = true;
                if (searchWord(target, targetPos + 1, board, currentX - 1, currentY, visited)) {
                    return true;
                }
                visited[currentX - 1][currentY] = false;
            }
            // 下 X + 1
            if (currentX + 1 < row && !visited[currentX + 1][currentY]) {
                visited[currentX + 1][currentY] = true;
                if (searchWord(target, targetPos + 1, board, currentX + 1, currentY, visited)) {
                    return true;
                }
                visited[currentX + 1][currentY] = false;
            }
            // 左 Y - 1
            if (currentY - 1 >= 0 && !visited[currentX][currentY - 1]) {
                visited[currentX][currentY - 1] = true;
                if (searchWord(target, targetPos + 1, board, currentX, currentY - 1, visited)) {
                    return true;
                }
                visited[currentX][currentY - 1] = false;
            }
            // 右 Y + 1
            if (currentY + 1 < col && !visited[currentX][currentY + 1]) {
                visited[currentX][currentY + 1] = true;
                if (searchWord(target, targetPos + 1, board, currentX, currentY + 1, visited)) {
                    return true;
                }
                visited[currentX][currentY + 1] = false;
            }
        }
        return false;
    }
}
