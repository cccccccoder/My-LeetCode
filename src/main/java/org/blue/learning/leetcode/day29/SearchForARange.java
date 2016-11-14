package org.blue.learning.leetcode.day29;

import java.util.Arrays;

/**
 * Created by klein on 2016/11/14.
 */
public class SearchForARange {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8)));
    }

    /**
     * Given a sorted array of integers, find the starting and ending position of a given target value.
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * If the target is not found in the array, return [-1, -1].
     * For example,
     * Given [5, 7, 7, 8, 8, 10] and target value 8,
     * return [3, 4].
     *
     * 二分查找法，查到指定的值，前后延伸寻找
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int pos = binarySearch(nums, target, 0, nums.length - 1);
        if (pos == -1) {
            return new int[] {-1, -1};
        }
        int begin = pos;
        for (; begin >=0; begin --) {
            if (nums[begin] != target) {
                break;
            }
        }
        begin ++;
        int end = pos;
        for (; end < nums.length; end ++) {
            if (nums[end] != target) {
                break;
            }
        }
        end --;
        return new int[] {begin, end};
    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
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
            return binarySearch(nums, target, left, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, right);
        }
    }


}
