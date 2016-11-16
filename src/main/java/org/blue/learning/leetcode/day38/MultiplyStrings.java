package org.blue.learning.leetcode.day38;

/**
 * @author leiyi
 * @date 2016-11-16 16:27
 * @summary:MultiplyStrings
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(multiply("20830956964977", "19922009292855299"));
    }

    /**
     * 计算两个整数的乘积
     * 但不能转为integer 不能用bigInteger
     * 数字不为负
     * 模拟手算乘法
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String result = "0";
        for (int i = num2.length() - 1; i >= 0; i --) {
            StringBuilder s = multiplySingle(num1, num2.charAt(i));
            for (int j = 0; j < num2.length() - 1 - i; j ++) {
                s.append("0");
            }
            result = addTwoNums(result, s.toString());
        }
        return result;
    }

    private static StringBuilder multiplySingle(String num1, char c2) {
        int temp = 0; // 进位
        StringBuilder result = new StringBuilder();
        for (int i = num1.length()- 1; i >= 0 ; i --) {
            char c1 = num1.charAt(i);
            int r = (c1 - '0') * (c2 - '0') + temp;
            result.append(r % 10);
            temp = r / 10;
        }
        if (temp != 0) {
            result.append(temp);
        }
        return result.reverse();
    }

    private static String addTwoNums(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int temp = 0; // 进位
        while (i1 >= 0 || i2 >= 0) {
            char c1 = i1 >= 0 ? num1.charAt(i1) : '0';
            char c2 = i2 >= 0 ? num2.charAt(i2) : '0';
            int r = (c1 - '0') + (c2 - '0') + temp;
            result.append(r % 10);
            temp = r / 10;
            i1 --;
            i2 --;
        }
        if (temp != 0) {
            result.append(temp);
        }
        return result.reverse().toString();
    }
}
