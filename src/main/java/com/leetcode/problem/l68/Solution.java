package com.leetcode.problem.l68;

import java.util.*;

/**
 * @author wangyongxu
 * @date 2020/8/22 11:14 下午
 */
public class Solution {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 遍历时记录路径
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pValues = new ArrayList<>();
        List<TreeNode> qValues = new ArrayList<>();

        List<TreeNode> pEndValues = getTrace(root, p);
        List<TreeNode> qEndValues = getTrace(root, q);
//        Deque<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            if (!pEndValues.isEmpty() && !qEndValues.isEmpty()) {
//                break;
//            }
//            TreeNode node = stack.pop();
//            pValues.add(node);
//            qValues.add(node);
//            if (node.left != null) {
//                stack.push(node.left);
//            }
//            if (node.right != null) {
//                stack.push(node.right);
//            }
//            if (node.left == null && node.right == null && node.val != p.val) {
//                pValues.clear();
//            }
//            if (node.left == null && node.right == null && node.val != q.val) {
//                qValues.clear();
//            }
//            if (node.val == p.val) {
//                pEndValues = pValues;
//            }
//            if (node.val == q.val) {
//                qEndValues = qValues;
//            }
//        }
        if (pEndValues.size() < qEndValues.size()) {
            return qEndValues.get(pEndValues.size() - 1);
        }
        if (pEndValues.size() > qEndValues.size()) {
            return pEndValues.get(qEndValues.size() - 1);
        }
        return qEndValues.get(0);

    }

    private static class TreeNodeWrapper extends TreeNode {

        public TreeNodeWrapper(TreeNode node, TreeNode p) {
            super(node.val);
            this.p = p;
        }

        TreeNode p;

    }


    List<TreeNode> getTrace(TreeNode root, TreeNode target) {
        List<TreeNode> qValues = new ArrayList<>();

        List<TreeNode> qEndValues = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            qValues.add(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left == null && node.right == null && node.val != target.val) {
                qValues.clear();
            }
            if (node.val == target.val) {
                break;
            }
        }
        return qValues;
    }


    public static void main(String[] args) {
//        String s = get();
//        System.out.println(s);
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        new Solution().lowestCommonAncestor(root, left, right);
    }

    static String get() {
        List<String> p = new ArrayList<>();
        p.add("3");
        p.add("5");

        List<String> q = new ArrayList<>();
        q.add("3");
        q.add("1");

        if (p.size() < q.size()) {
            return q.get(p.size() - 1);
        }
        if (p.size() > q.size()) {
            return p.get(q.size() - 1);
        }
        return q.get(0);
    }

    static String get1() {
        List<String> p = new ArrayList<>();
        p.add("3");
        p.add("5");

        List<String> q = new ArrayList<>();
        q.add("3");
        q.add("5");
        q.add("2");
        q.add("4");

        if (p.size() < q.size()) {
            return q.get(p.size() - 1);
        }
        if (p.size() > q.size()) {
            return p.get(q.size() - 1);
        }
        return q.get(0);
    }
}
