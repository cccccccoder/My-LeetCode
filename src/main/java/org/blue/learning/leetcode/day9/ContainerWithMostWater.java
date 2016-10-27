package org.blue.learning.leetcode.day9;

/**
 * @author leiyi
 * @date 2016-10-27 16:19
 * @summary:ContainerWithMostWater
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1, 2, 4, 3}));
    }

    public static int maxArea(int[] height) {
        if (height.length == 0 || height.length == 1) {
            return 0;
        }
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        // 左右推进，较短的那边推进，获取更高的边，查看是否面积会更大
        int left = 0;
        int right = height.length - 1;
        int maxArea;
        int w = Math.min(height[left], height[right]);
        int h = right - left;
        maxArea = w * h;
        while(left < right) {
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
            if (left >= right) {
                break;
            }
            w = Math.min(height[left], height[right]);
            h = right - left;
            int temp = w * h;
            if (temp > maxArea) {
                maxArea = temp;
            }
        }
        return maxArea;
    }
}
