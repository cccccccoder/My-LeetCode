package org.blue.learning.leetcode.day17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leiyi
 * @date 2016-11-01 10:56
 * @summary:GenerateParentheses
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        generateParenthesis(3);
    }

    /**
     * Given n pairs of parentheses, write a function to dfsGenerateParenthesis all combinations of well-formed parentheses.

         For example, given n = 3, a solution set is:

         [
         "((()))",
         "(()())",
         "(())()",
         "()(())",
         "()()()"
         ]
        思路：在打印所有的组合过程中
        '('的个数不能少于')'的个数
        利用递归求解
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        if (n == 1) {
            List<String> list = new ArrayList<>();
            list.add("()");
            return list;
        }
        StringBuilder s = new StringBuilder();
        int leftNum = 0 ;
        int rightNum = 0;
        int length = n * 2;
        List<String> result = new ArrayList<>();
        dfsGenerateParenthesis(s, leftNum, rightNum, length, result, '(');
        return result;
    }

    private static void dfsGenerateParenthesis(StringBuilder s, int leftNum, int rightNum, int length, List<String> result, char nextChar) {
        s.append(nextChar);
        switch (nextChar) {
            case '(':
                leftNum ++;
                break;
            case ')':
                rightNum ++;
                break;
        }
        if (leftNum + rightNum == length) {
            result.add(s.toString());
            return;
        }
        // 可以选择下一个字母为左括号或右括号
        // 左括号个数不能大于 length / 2;
        // 右括号不能大于左括号数;
        if (leftNum < (length / 2)) {
            dfsGenerateParenthesis(s, leftNum, rightNum, length, result, '(');
            s.deleteCharAt(s.length() - 1);
        }
        if (rightNum < leftNum) {
            dfsGenerateParenthesis(s, leftNum, rightNum, length, result, ')');
            s.deleteCharAt(s.length() - 1);
        }

    }
}
