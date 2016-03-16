package org.blue.learning.leetcode.day3;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leiyi
 * @date 2016-03-16 11:11
 * @summary:Solution
 */
public class Solution {

    public static void main(String[] args) {
        int[] result = twoSumIn5ms(new int[]{-1,-2,-3,-4,-5
        }, -8);
        printIntArray(result);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = null;
        boolean flag = false;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[j] == target - nums[i]) {
                    result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    flag = true;
                }
            }
            if (flag) {
                break;
            }
        }
        return result;
    }

    public static int[] twoSumIn5ms(int[] nums, int target) {
        int[] result = null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(nums[i])) {
                result = new int[2];
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return result;
    }

    public static void printIntArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
