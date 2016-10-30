package org.blue.learning.leetcode.day11;

import java.util.*;

/**
 * @author leiyi
 * @date 2016-10-28 16:25
 * @summary:ThreeSum
 */
public class ThreeSum {


    public static void main(String[] args) {
//        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        int [] nums = new int[] {-2,0,0,2,2};
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> triplets : list) {
            System.out.print("[");
            for (Integer i : triplets) {
                System.out.print(i + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     * 先排序数组，然后从左往右推
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int target;
        int left;
        int right;
        for (int i = 0; i < nums.length - 2; i ++) {
            if (nums[i] > 0) {
                // 如果当前数字大于0，则不用继续找下去了，因为后面的数都大于0
                break;
            }
            if(i > 0 && nums[i-1] == nums[i]) continue;
            target = 0 - nums[i]; // 接下来要找的2个数的和
            // 转化为2Sum问题
            // 左右指针推进
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int temp = nums[left] + nums[right];
                if (temp == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left ++;
                    right --;
                } else if (temp < target) {
                    left ++;
                } else if (temp > target) {
                    right --;
                }
            }
        }
        return result;
    }
}
