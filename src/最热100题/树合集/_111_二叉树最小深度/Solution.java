package 最热100题.树合集._111_二叉树最小深度;

import java.util.LinkedList;

class TreeNode {
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

public class Solution {
    public int minDepth(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) {
                    return depth + 1;
                }
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            depth++;
        }
        return depth;
    }

    //递归
    public int minDepth1(TreeNode root) {
        return getDepth(root);
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (root.left == null && root.right != null) {
            return 1 + rightDepth;
        }
        if (root.right == null && root.left != null) {
            return 1 + leftDepth;
        }
        int result = 1 + Math.min(leftDepth, rightDepth);
        return result;
    }
}
