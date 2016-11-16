package org.blue.learning.leetcode.day36;

/**
 * @author leiyi
 * @date 2016-11-16 14:07
 * @summary:FirstMissingPositive
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] array = new int[] {1};
        System.out.println(firstMissingPositive(array));
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * Given an unsorted integer array, find the first missing positive integer.
     * For example,
     * Given [1,2,0] return 3,
     * and [3,4,-1,1] return 2.
     * Your algorithm should run in O(n) time and uses constant space.
     * 遍历数组
     * i从0开始
     * 当index[i] != i + 1时
     * 将index[index[i] - 1] 与 index[i] 交换位置
     * 如果index[i]为负数或者超过数组的长度 则不管
     * 最后数组里的数字将会和下标一一对应
     * 找到第一个不与下标对应的数字即可
     * 如果都与下标对应，则返回数组的长度+1
     * 这里要考虑有重复数字的情况，如果有重复数字 要停止交换位置，不然会进入死循环
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {

        int result = 1;
        int temp;
        int index = 0;
        while (index < nums.length) {
            while (nums[index] != (index + 1) && nums[index] > 0 && nums[index] <= nums.length) {
                temp = nums[nums[index] - 1];
                if (temp == nums[index]) {
                    // 防止死循环
                    break;
                }
                nums[nums[index] - 1] = nums[index];
                nums[index] = temp;
            }
            index ++;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
            result++;
        }
        return result;
    }
}
