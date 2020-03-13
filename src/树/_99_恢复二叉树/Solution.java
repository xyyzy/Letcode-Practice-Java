package 树._99_恢复二叉树;

import java.util.*;

public class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
     * 利用中序遍历的特点 递增  如果出现 4 2 3 1
     * 那就将 4 1交换
     * */
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            //找到最左端的节点
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            //找到第一个前节点大于后节点的节点
            if (firstNode == null && pre.val > p.val) firstNode = pre;
            if (firstNode != null && pre.val > p.val) secondNode = p;
            pre = p;
            p = p.right;
        }
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
}
