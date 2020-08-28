package com.leetcode.problem.l129;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 * </pre>
 *
 * @author wangyongxu
 * @date 2020/8/28 17:48
 */
public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        int i = new Solution().sumNumbers(root);
        System.out.println(i);
    }

    private int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            sb.append(root.left.val);
            root.left.val = Integer.parseInt(sb.toString());
        }
        if (root.right != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            sb.append(root.right.val);
            root.right.val = Integer.parseInt(sb.toString());
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return sumNumbers(root.left) + sumNumbers(root.right);
    }
//    private void sumNumbers(TreeNode root, int sum) {
//        if (root == null) {
//            return;
//        }
//        if (root.left != null && root.right != null) {
//            int k = sum * 10 + root.val;
//        }
//        StringBuilder sb =
//    }
}
