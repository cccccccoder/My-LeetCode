package org.blue.learning.leetcode.day63;

import java.util.Stack;

/**
 * @author leiyi
 * @date 2016-12-01 16:03
 * @summary:SimplifyPath
 */
public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/"));
    }

    /**
     * Given an absolute path for a file (Unix-style), simplify it.
     * For example,
     * path = "/home/", => "/home"
     * path = "/a/./b/../../c/", => "/c"
     * @param path
     * @return
     */
    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String p : paths) {
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!"".equals(p) && !".".equals(p)){
                stack.push(p);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0,  "/" + stack.pop());
        }
        return result.toString();
    }
}
