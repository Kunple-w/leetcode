package com.leetcode.problem.l655;


import java.util.*;

/**
 * <pre>
 *     在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 *
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 * 示例 1:
 *
 * 输入:
 *      1
 *     /
 *    2
 * 输出:
 * [["", "1", ""],
 *  ["2", "", ""]]
 * 示例 2:
 *
 * 输入:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 * 示例 3:
 *
 * 输入:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * 输出:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 注意: 二叉树的高度在范围 [1, 10] 中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author wangyongxu
 * @date 2020/8/28 10:34
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
        root.left = left;
        List<List<String>> lists = new Solution().printTree(root);
        System.out.println(lists);
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> r = new ArrayList<>();
        if (root == null) {
            return r;
        }
        int depth = bfs(root);
        TreeNode zero = new TreeNode(0);
        Queue<TreeNode> queue = new LinkedList<>();

        int currentDepth = 1;
        int width = (int) Math.pow(2, depth) - 1;
        queue.offer(root);
        // 初始点
        int idx = (width - 1) / 2;
        // 步长
        int step = width + 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> line = initList(width);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                line.set(idx + i * step, node == zero ? "" : String.valueOf(node.val));

                if (node.left != null && node.left != zero) {
                    queue.offer(node.left);
                } else {
                    queue.offer(zero);
                }
                if (node.right != null && node.right != zero) {
                    queue.offer(node.right);
                } else {
                    queue.offer(zero);
                }
            }
            idx = (idx - 1) >> 1;
            step = step >> 1;
            r.add(line);
            if (currentDepth++ == depth) {
                break;
            }
        }
        return r;
    }

    private List<String> initList(int width) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            result.add("");
        }
        return result;
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
