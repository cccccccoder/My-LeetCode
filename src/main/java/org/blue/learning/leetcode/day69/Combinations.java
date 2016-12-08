package org.blue.learning.leetcode.day69;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leiyi
 * @date 2016-12-08 18:21
 * @summary:Combinations
 */
public class Combinations {

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * For example,
     * If n = 4 and k = 2, a solution is:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     * 就是从1--》n中选k个数去组合
     * 递归求解最简单
     * dfs
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] candidates = new int[n];
        for (int i = 1; i <= n; i ++) {
            candidates[i - 1] = i;
        }
        dfsGenerateCombinations(result, k, candidates, new ArrayList<>(), 0);
        return result;
    }

    private static void dfsGenerateCombinations(List<List<Integer>> result, int k, int[] candidates, List<Integer> oneSolution, int start) {
        if (oneSolution.size() == k) {
            result.add(new ArrayList<>(oneSolution));
            return;
        }
        for (int i = start; i < candidates.length; i ++) {
            oneSolution.add(candidates[i]);
            dfsGenerateCombinations(result, k, candidates, oneSolution, i + 1);
            oneSolution.remove(oneSolution.size() - 1);
        }
    }

}
