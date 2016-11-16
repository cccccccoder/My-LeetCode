package org.blue.learning.leetcode.day34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author leiyi
 * @date 2016-11-16 10:48
 * @summary:CombinationSum
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = new int[] {2, 2, 3, 6, 7};
        List<List<Integer>> result = combinationSum(candidates, 7);
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    /**
     * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
     * The same repeated number may be chosen from C unlimited number of times.
     * Note:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * For example, given candidate set [2, 3, 6, 7] and target 7,
     * A solution set is:
     * [
     * [7],
     * [2, 2, 3]
     * ]
     *
     * 所有数字都是正数
     *
     *
     * dfs递归遍历所有组合
     * 这里的数字可以重复，所以每次递归还要包括上一个数字
     * 先排序，可以跳过重复的数字
     * @param candidates
     * @param target
     * @return
     */

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        findSolution(candidates, target, 0, list, 0, new ArrayList<Integer>());
        return list;
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
            if (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                // 跳过重复
                continue;
            }
            if (lastSum + candidates[i] <= target) {
                oneSolution.add(candidates[i]);
                findSolution(candidates, target, i, result, lastSum + candidates[i], oneSolution);
                // 这里是回溯到上一层，需要去除掉最后一个数字
                oneSolution.remove(oneSolution.size() - 1);
            } else {
                // 数组已经排序，如果当前数字的和已超过target 无需继续循环下去
                break;
            }
        }
    }
}
