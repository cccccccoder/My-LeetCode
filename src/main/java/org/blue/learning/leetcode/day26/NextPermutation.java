package org.blue.learning.leetcode.day26;

import java.util.Arrays;

/**
 * Created by klein on 2016/11/13.
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3 ,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 从后往前找那个 先上升后下降的转折点
     * 比如 1 2 5 4 8 3 0
     * 3 - > 8 - > 4 是先上升后下降
     * 8 为转折点
     * 然后看8前面的数字在8后面的数列中能排在哪个位置，按倒序、、
     * 这里就是4 可以排在 8 和 3之间
     * 所以交换8和4的位置
     * 变成
     * 1 2 4 8 4 3 0
     * 然后再把后面的 4 3 0 倒序过来
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int p = -1;
        for (int i = nums.length - 1; i > 0; i --) {
            if (nums[i] > nums[i - 1]) {
                p = i;
                break;
            }
        }
        if (p == -1) {
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = temp;
            }
        } else {
            int n =  nums.length - 1;
            for (int i = p + 1; i < nums.length; i ++) {
                if (nums[p - 1] >= nums[i]) {
                    n = i - 1;
                    break;
                }
            }
            int temp = nums[p - 1];
            nums[p - 1] = nums[n];
            nums[n] = temp;
            for (int i = p, j = 0; i < p + ((nums.length - p) / 2); i ++, j ++) {
                temp = nums[i];
                nums[i] = nums[nums.length - 1 - j];
                nums[nums.length - 1 - j] = temp;
            }

        }
    }
}
