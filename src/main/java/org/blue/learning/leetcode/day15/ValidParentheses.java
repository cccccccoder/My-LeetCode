package org.blue.learning.leetcode.day15;

import java.util.Stack;

/**
 * Created by klein on 2016/10/31.
 */
public class ValidParentheses {

    public static void main(String[] args) {
//        System.out.println(isValid("([)]"));
//        System.out.println(isValid("(]"));
        System.out.println(isValid("()[]{}"));
    }

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     * 利用栈
     * 遇到( { [ 则入栈
     * 遇到) } ] 则出栈
     * 最后栈不为空，则非法，出栈的时候，如果对不上上一个符号，也为非法
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char lastChar = stack.peek();
                    if (lastChar != '(') {
                        return false;
                    }
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    lastChar = stack.peek();
                    if (lastChar != '[') {
                        return false;
                    }
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    lastChar = stack.peek();
                    if (lastChar != '{') {
                        return false;
                    }
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }
}
