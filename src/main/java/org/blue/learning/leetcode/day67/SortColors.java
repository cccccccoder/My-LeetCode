package org.blue.learning.leetcode.day67;

/**
 * @author leiyi
 * @date 2016-12-02 18:06
 * @summary:SortColors
 */
public class SortColors {

    public static void main(String[] args) {
        sortColors(new int[] {2, 2});
    }

    /**
     * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     * Note:
     * You are not suppose to use the library's sort function for this problem.
     * click to show follow up.
     * Subscribe to see which companies asked this question
     *
     * 因为数字只有0, 1, 2 三种
     * 只需要遍历一遍数组，记录0有几个 1有几个 2有几个
     * 然后再遍历一遍数组去赋值。。
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int countOf0 = 0;
        int countOf1 = 0;
        int countOf2 = 0;
        for (int i : nums) {
            if (i == 0) {
                countOf0 ++;
            } else if (i == 1) {
                countOf1 ++;
            } else if (i == 2) {
                countOf2 ++;
            }
        }
        for (int i = 0; i < countOf0; i ++) {
            nums[i] = 0;
        }
        for (int i = 0; i < countOf1; i ++) {
            nums[i + countOf0] = 1;
        }
        for (int i = 0; i < countOf2; i ++) {
            nums[i + countOf0 + countOf1] = 2;
        }
    }
}
