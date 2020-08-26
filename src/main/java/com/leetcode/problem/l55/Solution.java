package com.leetcode.problem.l55;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wangyongxu
 * @date 2020/8/22 10:43 下午
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return bfs(root);
    }

    public int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;

        }
        return depth;
    }

}
