package org.blue.learning.leetcode.day22;

/**
 * @author leiyi
 * @date 2016-11-02 18:18
 * @summary:RemoveElement
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] array = new int[] {3,2,2,3,2,4,5};
        System.out.println(removeElement(array, 22));
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static int removeElement(int[] nums, int val) {

        int count = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count ++;
            }
        }
        return count;
    }
}
