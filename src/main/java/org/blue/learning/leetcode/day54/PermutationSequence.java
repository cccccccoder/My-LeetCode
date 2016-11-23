package org.blue.learning.leetcode.day54;

/**
 * Created by klein on 2016/11/22.
 */
public class PermutationSequence {

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 2));
    }

    /**
     * The set [1,2,3,…,n] contains a total of n! unique permutations.
     * By listing and labeling all of the permutations in order,
     * We get the following sequence (ie, for n = 3):
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * Given n and k, return the kth permutation sequence.
     * 利用之前的nextPermutation
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i ++) {
            nums[i] = i + 1;
        }
        for (int i = 0; i < k - 1; i ++) {
            nextPermutation(nums);
        }
        StringBuilder result = new StringBuilder();
        for (int i : nums) {
            result.append(i);
        }
        return result.toString();
    }
    private static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int p = -1;
        for (int i = nums.length - 1; i > 0; i --) {
            if (nums[i] > nums[i - 1]) {
                p = i;
                break;
            }
        }
        if (p == -1) {
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = temp;
            }
        } else {
            int n =  nums.length - 1;
            for (int i = p + 1; i < nums.length; i ++) {
                if (nums[p - 1] >= nums[i]) {
                    n = i - 1;
                    break;
                }
            }
            int temp = nums[p - 1];
            nums[p - 1] = nums[n];
            nums[n] = temp;
            for (int i = p, j = 0; i < p + ((nums.length - p) / 2); i ++, j ++) {
                temp = nums[i];
                nums[i] = nums[nums.length - 1 - j];
                nums[nums.length - 1 - j] = temp;
            }

        }
    }
}
