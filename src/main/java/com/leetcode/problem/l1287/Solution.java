package com.leetcode.problem.l1287;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyongxu
 * @date 2020/8/22 12:31 上午
 */
public class Solution {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 1, 2, 2, 3, 3, 3, 3};
        int[] arr = new int[]{1, 2, 3, 3};
        int specialInteger = new Solution().findSpecialInteger(arr);
        System.out.println(specialInteger);
    }

    public int findSpecialInteger(int[] arr) {
        if (arr.length < 4) {
            return arr[0];
        }

        // 25%的阈值
        double expect = arr.length / 4.0;

        int lastValue = arr[0];

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i < 1) {
                continue;
            }
            if (lastValue == arr[i]) {
                count++;
            } else {
                count = 0;
            }
            if (count > expect) {
                return arr[i];
            }
            lastValue = arr[i];
        }
        if (count > expect) {
            return lastValue;
        }
        throw new IllegalArgumentException("xxx");
    }
}
