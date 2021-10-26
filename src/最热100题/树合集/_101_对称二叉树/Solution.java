package 最热100题.树合集._101_对称二叉树;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public class TreeNode {
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

    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    /*
     * 递归
     * */
    private boolean helper(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null) {
            return true;
        }
        if (root == null || root1 == null) {
            return false;
        }
        return root.val == root1.val && helper(root.left, root1.right) && helper(root.right, root1.left);
    }


    /*
     * 栈迭代
     * */
    private boolean helper1(TreeNode root, TreeNode root1) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        stack.push(root1);
        while (!stack.isEmpty()) {
            root = stack.pop();
            root1 = stack.pop();
            if (root1==null&&root==null)
                continue;
            if (root==null||root1==null || root!=root1)
                return false;
            stack.push(root.left);
            stack.push(root1.right);

            stack.push(root.right);
            stack.push(root1.left);
        }
        return true;
    }

}
