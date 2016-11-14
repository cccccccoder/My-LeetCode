package org.blue.learning.leetcode.day30;

/**
 * Created by klein on 2016/11/14.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1,3,5,6}, 2));
    }

    /**
     * Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array.
     * Here are few examples.
     * [1,3,5,6], 5 → 2
     * [1,3,5,6], 2 → 1
     * [1,3,5,6], 7 → 4
     * [1,3,5,6], 0 → 0
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        return binarySearchInsertPos(nums, target, 0, nums.length - 1);
    }

    public static int binarySearchInsertPos(int[] nums, int target, int left, int right) {
        if (left > right) {
            return right + 1;
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return binarySearchInsertPos(nums, target, left, mid - 1);
        } else {
            return binarySearchInsertPos(nums, target, mid + 1, right);
        }
    }
}
