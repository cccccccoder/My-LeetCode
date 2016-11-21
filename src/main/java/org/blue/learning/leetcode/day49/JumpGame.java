package org.blue.learning.leetcode.day49;

/**
 * @author leiyi
 * @date 2016-11-21 18:40
 * @summary:JumpGanme
 */
public class JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0, 2, 3}));
    }

    /**
     * 没什么好解释的
     * 遍历数组，计算能够到达的最大范围
     * 对于数组中的某个位置i
     * 它能到达的最远位置为nums[i] + i;
     * 所以遍历每个位置，判断以当前位置为起点能到的位置远，还是之前能到的位置远
     * 注意i 要小于 reach，因为某些位置可能为0，这时候是不能前进的
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int reach = 0;
        int i = 0;
        for ( ; i < nums.length && i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]);
        }
        return (i == nums.length);
    }
}
