package org.blue.learning.leetcode.day58;

import javax.xml.stream.events.Characters;

/**
 * @author leiyi
 * @date 2016-11-24 17:32
 * @summary:ValidNumber
 */
public class ValidNumber {

    public static void main(String[] args) {
        System.out.println(isNumber("ddas"));
    }


    /**
     * 最简单的方法 哈哈
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        try {
            s = s.trim();
            if (s.charAt(s.length() - 1) != '.' && !Character.isDigit(s.charAt(s.length() - 1))){
                return false;
            }
            Double.parseDouble(s);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
