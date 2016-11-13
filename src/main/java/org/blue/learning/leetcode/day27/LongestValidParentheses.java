package org.blue.learning.leetcode.day27;

import java.util.Stack;

/**
 * Created by klein on 2016/11/13.
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }

    public static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < s.length(); i ++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (!stack.isEmpty()) {
                        char c = stack.peek();
                        if (c == '(') {
                            result += 2;
                            stack.pop();
                        }
                    }
                    break;
            }
        }
        return result;
    }
}
