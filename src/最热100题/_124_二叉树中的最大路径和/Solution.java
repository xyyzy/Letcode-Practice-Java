package 最热100题._124_二叉树中的最大路径和;

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

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return  maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        //当前子树内部的最大路径和
        int innerMax = root.val + left + right;
        //挑战最大纪录
        maxSum = Math.max(maxSum, innerMax);
        //当前子树对外提供的最大和
        int outMax = root.val+Math.max(left,right);
        // 对外提供的路径和为负，直接返回0
        if (outMax < 0)
            return 0;

        return outMax;
    }
}
