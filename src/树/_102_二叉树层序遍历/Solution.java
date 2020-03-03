package 树._102_二叉树层序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
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
}
