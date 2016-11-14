package org.blue.learning.leetcode.day28;

/**
 * @author leiyi
 * @date 2016-11-14 17:32
 * @summary:SearchInRotatedSortedArray
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

    }

    /**
     * 二分查找，但要考虑旋转点的存在
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // 找到旋转点

        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (nums[left] < nums[right]) {
            return binarySearch(nums, target, left, right);
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[left] > nums[mid]) {
            // mid是属于右半段的
            if (nums[mid + 1] <= target && nums[right] >= target) {
                return binarySearch(nums, target, mid + 1, right);
            } else {
                return search(nums, target, left, mid);
            }
        } else {
            // mid 属于左半端
            if (nums[mid] >= target && nums[left] <= target) {
                return binarySearch(nums, target, left, mid);
            } else {
                return search(nums, target, mid + 1, right);
            }
        }
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
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
        if (nums[mid] > target) {
            return binarySearch(nums, target, left, mid);
        } else {
            return binarySearch(nums, target, mid + 1, right);
        }
    }
}
