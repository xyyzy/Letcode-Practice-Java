package 最热100题._114_二叉树展开为链表;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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

    /**
     * 递归版本
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        helper(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.right = curr;
            prev.left = null;
        }
    }

    private void helper(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        list.add(root);
        helper(root.left, list);
        helper(root.right, list);
    }


    /**
     * 迭代版本
     */
    public void flatten1(TreeNode root) {
        if (root==null)
            return;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode pre = null;
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (pre!=null){
                pre.right = temp;
                pre.left = null;
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }

            pre = temp;
        }

    }

}
