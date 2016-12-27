package org.blue.learning.leetcode.day72;

/**
 * @author leiyi
 * @date 2016-12-27 19:27
 * @summary:RemoveDuplicatesFromSortedArrayII
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] array = new int[] {1, 1, 1, 2, 2, 3};
        removeDuplicates(array);
        for (int i : array) {
            System.out.print(i + " ");
        }

    }

    /**
     * Follow up for "Remove Duplicates":
     * What if duplicates are allowed at most twice?
     * For example,
     * Given sorted array nums = [1,1,1,2,2,3],
     * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
     * It doesn't matter what you leave beyond the new length.
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length <=2 ) {
            return nums.length;
        }
        int result = 1;
        int temp = nums[1];
        for (int i = 2; i < nums.length; i ++) {
            if (nums[i - 2] != nums[i]) {
                nums[result ++] = temp;
                temp = nums[i];
            }
        }
        nums[result ++] = temp;
        return result;
    }
}
