package org.blue.learning.leetcode.day37;

/**
 * @author leiyi
 * @date 2016-11-16 14:55
 * @summary:TrappingRainWater
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
     * For example,
     * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int result = 0;
        // 先找到最高点
        // 然后从左右往最高点扫描
        if (height.length < 3) {
            return 0;
        }
        int max = height[0];
        int maxIndex = 0;
        for (int i = 1; i < height.length; i ++) {
            if (height[i] >= max) {
                max = height[i];
                maxIndex = i;
            }
        }
        int left = 0;
        int right = height.length - 1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        while (left < maxIndex) {
            if (height[left] > leftHeight) {
                leftHeight = height[left];
            } else {
                result += leftHeight - height[left];
            }
            left ++;
        }
        while (right > maxIndex) {
            if (height[right] > rightHeight) {
                rightHeight = height[right];
            } else {
                result += rightHeight - height[right];
            }
            right --;
        }
        return result;
    }
}
