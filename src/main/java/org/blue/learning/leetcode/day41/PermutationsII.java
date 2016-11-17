package org.blue.learning.leetcode.day41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leiyi
 * @date 2016-11-17 15:21
 * @summary:PermutationsII
 */
public class PermutationsII {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2};
        List<List<Integer>> result = permuteUnique(nums);
        for (List<Integer> list : result) {
            System.out.print("[ ");
            for (Integer i  : list) {
                System.out.print(i);
            }
            System.out.println(" ] ");
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        doPermute(nums, result, new ArrayList<Integer>(), used);
        return result;
    }

    /**
     * 和上一题类似，但是需要去重
     * 要先排序，然后每次循环跳过重复的
     * @param nums
     * @param result
     * @param oneSolution
     */
    private static void doPermute(int[] nums, List<List<Integer>> result, List<Integer> oneSolution, boolean[] used) {
        if (oneSolution.size() == nums.length) {
            result.add(new ArrayList<>(oneSolution));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (used[i]) {
                continue;
            }

            oneSolution.add(nums[i]);
            used[i] = true;
            doPermute(nums, result, oneSolution, used);
            oneSolution.remove(oneSolution.size() - 1);
            used[i] = false;
            // 跳过重复的
            // 该循环必须放这里
            // 否则一开始就跳过重复数字 会导致第一个数字没法使用
            // 因为使用的都是最后一个没有重复的数字
            //
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i ++;
            }
        }
    }
}
