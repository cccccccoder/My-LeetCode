package org.blue.learning.leetcode.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leiyi
 * @date 2016-10-28 16:25
 * @summary:ThreeSum
 */
public class ThreeSum {


    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     * 先排序数组，然后从左往右推
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < nums.length - 2; i ++) {
            if (nums[i] > 0) {
                // 如果
                break;
            }
            temp = 0 - nums[i];
            // 转化为2Sum问题
            for (int j = i + 1; j < nums.length - 1; j ++) {

            }
        }
        return null;

    }
}
