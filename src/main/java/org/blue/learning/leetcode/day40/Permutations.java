package org.blue.learning.leetcode.day40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leiyi
 * @date 2016-11-17 15:04
 * @summary:Permutations
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        for (List<Integer> list : result) {
            System.out.print("[ ");
            for (Integer i  : list) {
                System.out.print(i);
            }
            System.out.println(" ] ");
        }
    }

    /**
     * Given a collection of distinct numbers, return all possible permutations.
     * For example,
     * [1,2,3] have the following permutations:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     * 输出全排列，回溯法，
     * 用递归是最简单的 哈哈
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        doPermute(nums, result, new ArrayList<Integer>(), used);
        return result;
    }

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
        }
    }
}
