package 树._144_二叉树的前序遍历_mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    * 递归
    * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }
    private void helper (TreeNode root,List<Integer> list){
        if (root==null) {
            return;
        }
        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
    }

    /*
    * 栈的迭代
    * */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root==null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node!=null) {
                list.add(node.val);
            }
            //因为stack先进后出所以先添加右节点
            if (node.right!=null) {
                stack.push(node.right);
            }
            if (node.left!=null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    /*
    *
    * */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root==null) {
            return list;
        }
        TreeNode node = root;
        while (!stack.isEmpty()||node!=null){
            //找到最左边的节点
            while (node!=null){
                list.add(node.val);
                stack.push(node);
                node=node.left;
            }
            if (!stack.isEmpty()){
                node = stack.pop();
                node=node.right;
            }
        }
        return list;
    }

}
