package 剑指offer._27_二叉树的镜像;

import java.util.ArrayDeque;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //栈
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            //原先右节点变为左节点
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }

    //递归
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left=mirrorTree1(root.right);
        root.right = mirrorTree1(temp);
        return root;
    }

}
