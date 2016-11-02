package org.blue.learning.leetcode.day21;

/**
 * @author leiyi
 * @date 2016-11-02 17:38
 * @summary:RemoveDuplicatesFromSortedArray
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] array = new int[] {0,0,0,0,0,1,2,2,3,3,4,4};
        int result = removeDuplicates(array);
        System.out.println(result);
        for (int a : array) {
            System.out.println(a);
        }

    }

    /**
     *
     * 指定一个计数器从1开始
     * 从计数器的位置开始遍历数组
     * 如果当前数字和上一个数字不一样
     * 将计数器所指的位置置为这个数字
     * 计数器+1
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
