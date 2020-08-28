package com.leetcode.problem.l1480;

/**
 * @author wangyongxu
 * @date 2020/8/28 18:36
 */
public class Solution {
    public int[] runningSum(int[] nums) {
        int[] r = new int[nums.length];
        for (int i = 1; i < nums.length + 1; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += nums[j];
            }
            r[i-1] = sum;
        }
        return r;
    }
}
