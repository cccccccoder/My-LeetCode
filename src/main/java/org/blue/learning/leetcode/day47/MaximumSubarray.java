package org.blue.learning.leetcode.day47;

/**
 * @author leiyi
 * @date 2016-11-18 15:24
 * @summary:MaximumSubarray
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.For example,
     * given the array [-2,1,-3,4,-1,2,1,-5,4],
     * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     * 用一个数组max[] 记录前i个数字中最大的和
     * 即max[i] 表示0--》i的数组中最大的和
     * 当求max[i+1]时，判断nums[i+1] + max[i] 和nums[i+1]哪个大，取最大值，然后再拿max[i+1]与之前求出的最大值想比，看谁大
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
//        return doFigureOutMaxSubArray(0, nums.length - 1, nums);
        int[] max = new int[nums.length];
        max[0] = nums[0];
        int result = max[0];
        for (int i = 1; i < nums.length; i ++) {
            max[i] = Math.max(nums[i], nums[i] + max[i - 1]);
            result = Math.max(result, max[i]);
        }
        return result;
    }

    private static int doFigureOutMaxSubArray(int left, int right, int[] nums) {
        if(left == right)
            return nums[left];
        int mid = left + (right - left) / 2;
        int lmax = doFigureOutMaxSubArray(left, mid, nums);
        int rmax = doFigureOutMaxSubArray(mid + 1, right, nums);
        int mmax = 0;
        int tmp = mmax;
        for(int i = mid; i >= left; i--){
            tmp += nums[i];
            if(tmp > mmax)
                mmax = tmp;
        }
        tmp = mmax;
        for(int i = mid + 1; i <= right; i++){
            tmp += nums[i];
            if(tmp > mmax)
                mmax = tmp;
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }



}
