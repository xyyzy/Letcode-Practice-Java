package 最热100题.树合集._222_完全二叉节点个数;

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

class Solution {
    public int countNodes(TreeNode root) {
        return getNum(root);
    }

    private int getNum(TreeNode root) {
        if (root == null)
            return 0;
        int lnum = getNum(root.left);
        int rnum = getNum(root.right);
        return lnum + rnum + 1;
    }


    //迭代法
    public int countNodes1(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                result++;
                if (temp.left!=null) queue.offer(temp.left);
                if (temp.right!=null) queue.offer(temp.right);
            }
        }
        return result;
    }
}