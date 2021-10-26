package 最热100题.树合集._102_二叉树的层序遍历;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        if (root==null)
            return list;
        deque.add(root);
        while (!deque.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < deque.size(); i++) {
                TreeNode node = deque.poll();
                level.add(node.val);
                if (node.left!=null)
                    deque.add(node.left);
                if (node.right!=null)
                    deque.add(node.right);
            }
            list.add(level);
        }
        return list;

    }
}
