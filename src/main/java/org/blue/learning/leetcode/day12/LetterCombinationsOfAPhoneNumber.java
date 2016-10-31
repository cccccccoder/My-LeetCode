package org.blue.learning.leetcode.day12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leiyi
 * @date 2016-10-31 11:02
 * @summary:LetterCombinationsOfAPhoneNumber
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        for (String s : letterCombinations("")) {
            System.out.println(s);
        }
    }

    public static List<String> letterCombinations(String digits) {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        int[] digitsArray = new int[digits.length()];
        for (int i = 0; i < digits.length(); i ++) {
            digitsArray[i] = Integer.valueOf(digits.charAt(i) + "");
        }
        StringBuilder stringBuilder = new StringBuilder();
        dfsCombineStr(mapping, 0, digitsArray, 0, result, stringBuilder);
        return result;

    }

    private static void dfsCombineStr(String[] mapping, int index, int[] digits, int digitIndex, List<String> result, StringBuilder combineStr) {
        if (digitIndex == digits.length) {
            if (combineStr.length() > 0) {
                result.add(combineStr.toString());
            }
            return;
        }
        int currentDigit = digits[digitIndex];
        String s = mapping[currentDigit];
        for (; index < s.length(); index ++) {
            combineStr.append(s.charAt(index));
            dfsCombineStr(mapping, 0, digits,  digitIndex + 1, result, combineStr);
            // 递归回到上一层时，需要去掉最后一个字母，因为这个字母是下一层的
            combineStr.deleteCharAt(combineStr.length() - 1);
        }
    }
}
