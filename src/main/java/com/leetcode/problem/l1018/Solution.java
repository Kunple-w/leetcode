package com.leetcode.problem.l1018;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 *
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author wangyongxu
 * @date 2020/8/21 11:53 下午
 */
public class Solution {
    // 1010 以10结尾, 101以5结尾
    // 100 1001
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> r = new ArrayList<Boolean>(A.length);
        StringBuilder stringBuilder = new StringBuilder();
        for (int value : A) {
            stringBuilder.append(value);
            if (stringBuilder.toString().endsWith("1010") || stringBuilder.toString().endsWith("101")) {
                r.add(true);
            } else {
                r.add(false);
            }
        }

        return r;
    }
}
