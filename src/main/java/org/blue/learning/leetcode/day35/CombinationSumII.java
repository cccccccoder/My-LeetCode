package org.blue.learning.leetcode.day35;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leiyi
 * @date 2016-11-16 11:34
 * @summary:CombinationSumII
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = new int[] {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = combinationSum2(candidates, 8);
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    /**
     * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
     * Each number in C may only be used once in the combination.
     * Note:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
     * A solution set is:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     * 与上一个题类似
     * 但是这边的数字只能用一次
     *
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findSolution(candidates, target, 0, result, 0, new ArrayList<Integer>());
        return result;
    }

    private static void findSolution(int[] candidates, int target, int currentIndex, List<List<Integer>> result, int lastSum, List<Integer> oneSolution) {
        if (lastSum > target) {
            return;
        }
        if (lastSum == target) {
            List<Integer> oneResult = new ArrayList<>(oneSolution);
            result.add(oneResult);
            return;
        }
        for (int i = currentIndex; i < candidates.length; i ++) {
            if (i != currentIndex && candidates[i] == candidates[i - 1]) {
                // 跳过重复
                continue;
            }
            if (lastSum + candidates[i] <= target) {
                oneSolution.add(candidates[i]);
                findSolution(candidates, target, i + 1, result, lastSum + candidates[i], oneSolution);
                // 这里是回溯到上一层，需要去除掉最后一个数字
                oneSolution.remove(oneSolution.size() - 1);
            } else {
                break;
            }
        }
    }
}
