package org.blue.learning.leetcode.day39;

import java.util.Arrays;

/**
 * @author leiyi
 * @date 2016-11-17 10:38
 * @summary:JumpGameII
 */
public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = new int[25000];
        Arrays.fill(nums, 1);
        System.out.println(jump(nums));

    }

    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Your goal is to reach the last index in the minimum number of jumps.
     * For example:
     * Given array A = [2,3,1,1,4]
     * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
     * Note:
     * You can assume that you can always reach the last index.
     * 贪心法
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int i = 0;
        int maxReach = 0;
        int maxJump = 0;
        int step = 0;
        // 遍历整个数组，算出每个位置的最大可达的范围，当遍历到某个位置超过之前最大的可达范围时，
        // 跳一步，更新maxReach
        // 因为在碰到i > maxReach之前的范围内，都是可以在上一步的基础到跳一步到达的
        // 所以在 i > maxReach时， 步数只需要增加一步就可以到达当前可以到达的最大范围
        for (; i < nums.length; i ++) {
            if (i > maxReach) {
                // 如果当前位置已经到了之前可以到的最大位置
                // 需要跳1步
                step ++;
                maxReach = maxJump;
            }
            maxJump = Math.max(maxJump, nums[i] + i);
        }
        return step;
    }
}
