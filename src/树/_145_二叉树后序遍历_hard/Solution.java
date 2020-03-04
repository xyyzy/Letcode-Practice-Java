package 树._145_二叉树后序遍历_hard;

import java.util.ArrayList;
import java.util.Collections;
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
    * 递归形式
    * */
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }
    private void helper(TreeNode root,List<Integer>list){
        if (root==null)
            return;
        helper(root.left,list);
        helper(root.right,list);
        list.add(root.val);
    }

    /*
    * 利用栈迭代
    * */
    public List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur!=null||!stack.isEmpty()){
            //找到最左端节点
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            //获得栈顶的元素但不删除
            cur = stack.peek();
            //表示已经访问过右子树
            if (cur.right==null||cur.right==pre){
                list.add(cur.val);
                pre = cur;
                cur = null;
                stack.pop();
            }else {
                cur= cur.right;
            }

        }
        return list;
    }

    /*
    * 利用前序遍历 根-左-右  后序遍历 左-右-根
    * 所以先变成 根-右-左
    * 先按前序遍历的规则 然后reverse
    * */
    public List<Integer> postorderTraversal3(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root==null)
            return list;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            //先入后出所以
            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
