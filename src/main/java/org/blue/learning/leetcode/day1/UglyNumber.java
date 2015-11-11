package org.blue.learning.leetcode.day1;

import java.util.Scanner;

/**
 * @author leiyi
 * @date 2015-11-09 18:03
 * @summary:Day1Lesson
 */
public class UglyNumber {

    public static void main(String[] args) {

        UglyNumber uglyNumber = new UglyNumber();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println("the " + n + "-th ugly number is: " + uglyNumber.nthUglyNumber(n));
        }
    }

    /**
     * Write a program to find the n-th ugly number.
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
     * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
     * Note that 1 is typically treated as an ugly number.
     * @param n
     * @return
     *
     * 假设要找的丑数为Cn，Cn必定是之前的丑数乘以2或3或5的结果（但不一定是Cn-1，如4=2*2,5=5*1,1和2是之前的丑数）
     * 那么我们可以从第一个丑数开始，乘以2,3,5来生成接下来的丑数，但是为了保证顺序，需要知道生成下一个丑数时，是乘以2还是3还是5
     * 并且用来生成丑数的这个数所在的索引位置
     */
    public long nthUglyNumber(int n) {
        long[] uglyNumbers = new long[n];
        uglyNumbers[0] = 1;
        int currentIndex = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while (currentIndex < n) {
            uglyNumbers[currentIndex] = min(uglyNumbers[index2] * 2, uglyNumbers[index3] * 3, uglyNumbers[index5] * 5);
            // 找到最小的2倍丑数
            while(index2 <= currentIndex && uglyNumbers[index2] * 2 <= uglyNumbers[currentIndex]){
                index2 ++;
            }
            // 找到最小的3倍丑数
            while(index3 <= currentIndex && uglyNumbers[index3] * 3 <= uglyNumbers[currentIndex]){
                index3 ++;
            }
            // 找到最小的5倍丑数
            while(index5 <= currentIndex &&
                    uglyNumbers[index5] * 5 <= uglyNumbers[currentIndex]){
                index5 ++;
            }
            currentIndex ++;
        }
        return uglyNumbers[n - 1];
    }


    public long min(long a, long b, long c) {
        long min = a < b ? a: b;
        min = min < c ? min : c;
        return min;
    }
}
