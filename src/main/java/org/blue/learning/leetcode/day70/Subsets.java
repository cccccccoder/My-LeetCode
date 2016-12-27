package org.blue.learning.leetcode.day70;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leiyi
 * @date 2016-12-08 18:36
 * @summary:Subsets
 */
public class Subsets {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3};
        List<List<Integer>> result = subsets(array);
        for (List<Integer> list : result) {
            System.out.print("[ ");
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }

    /**
     * Given a set of distinct integers, nums, return all possible subsets.
     * Note: The solution set must not contain duplicate subsets.
     * For example,
     * If nums = [1,2,3], a solution is:
     * [
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> oneSolution = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i <= len; i ++) {
            findSubSets(nums, 0, i, result, oneSolution);
        }
        return result;
    }

    private static void findSubSets(int[] nums, int startPos, int len, List<List<Integer>> result, List<Integer> oneSolution) {
        if (oneSolution.size() == len) {
            result.add(new ArrayList<>(oneSolution));
            return;
        }
        for (int i = startPos; i < nums.length; i ++) {
            oneSolution.add(nums[i]);
            findSubSets(nums, i + 1, len, result, oneSolution);
            oneSolution.remove(oneSolution.size() - 1);
        }
    }

}
