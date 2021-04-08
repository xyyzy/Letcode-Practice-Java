package 剑指offer._28_对称二叉树;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return help(root.left, root.right);
    }

    private boolean help(TreeNode root, TreeNode temp) {

        if (root == null && temp == null)
            return true;
        if (root == null || temp == null || root.val != temp.val) return false;

        return help(root.left, temp.right) && help(root.right, temp.left);

    }
}
