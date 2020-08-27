package com.leetcode.problem.l100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author wangyongxu
 * @date 2020/8/27 10:47
 */
public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        TreeNode[] treeNodes = new TreeNode[]{p, q};
        Deque<TreeNode[]> stack = new LinkedList<>();
        stack.push(treeNodes);
        while (!stack.isEmpty()) {
            TreeNode[] ele = stack.pop();
            if ((ele[0] == null && ele[1] != null) || (ele[0] != null && ele[1] == null) || (ele[0].val != ele[1].val)) {
                return false;
            }
            if (ele[0].left != null && ele[1].left != null) {
                stack.push(new TreeNode[]{ele[0].left, ele[1].left});
            }
            if (ele[0].right != null && ele[1].right != null) {
                stack.push(new TreeNode[]{ele[0].right, ele[1].right});
            }
            if ((ele[0].left != null ^ ele[1].left != null) || (ele[0].right != null ^ ele[1].right != null)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if ((p != null && q != null) && (p.val != q.val)) {
            return false;
        }
        if ((p == null) && (q != null)) {
            return false;
        }
        if ((p != null) && (q == null)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }

        return isSameTree1(p.left, q.left) || isSameTree1(p.right, q.right);

    }
}
