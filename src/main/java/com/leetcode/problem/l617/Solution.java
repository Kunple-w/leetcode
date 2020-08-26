package com.leetcode.problem.l617;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * <pre>
 *     给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author wangyongxu
 * @date 2020/8/24 12:26 上午
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return dfs(t1, t2);
    }


    public TreeNode dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        // 2个栈，深度遍历
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.push(t1);
        stack2.push(t2);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();

            // 左右节点存在时都入栈
            if (node1.left != null && node2.left != null) {
                stack1.push(node1.left);
                stack2.push(node2.left);
            }
            if (node1.right != null && node2.right != null) {
                stack1.push(node1.right);
                stack2.push(node2.right);
            }
            // 不入栈,进行移花接木，如果node1左节点不存在但是node2左节点存在，将2左赋值给1左
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            // 同上
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }

            node1.val = node1.val + node2.val;

        }

        return t1;
    }
}
