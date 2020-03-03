package 树._102_二叉树层序遍历_mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public class TreeNode {
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
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
            return list;
        int level =0;
        helper(root,level);
        return  list;
    }

    private void helper(TreeNode node,int level){
        if (list.size()==level)
            list.add(new ArrayList<Integer>());
        list.get(level).add(node.val);
        if (node.left!=null)
            helper(node.left,level+1);
        if (node.right!=null)
            helper(node.right,level+1);
    }
    /*
    * 迭代
    * */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            lists.add(new ArrayList<Integer>());

            int level_size = queue.size();
            for (int i = 0; i <level_size; i++) {
                TreeNode temp = queue.remove();
                lists.get(level).add(temp.val);
                if (temp.left!=null)
                    queue.add(temp.left);
                if (temp.right!=null)
                    queue.add(temp.right);
            }
            level++;
        }
        return lists;
    }
}
