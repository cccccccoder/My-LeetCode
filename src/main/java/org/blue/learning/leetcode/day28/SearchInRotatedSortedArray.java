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

        return 0;
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
        int mid = left + (left - right) / 2;
        if (nums[mid] < nums[left]) {
            // mid 在右半段
            if (target > nums[mid]) {
                // 目标数字大于中间数字 可能在右半段 也可能在左半段
                if (target == nums[left]) {
                    return left;
                } else if (target > nums[left]) {

                }
            } else {
                // 目标数字比中间数字小，一定在左半段
            }
        }
        return -1;
    }
}
