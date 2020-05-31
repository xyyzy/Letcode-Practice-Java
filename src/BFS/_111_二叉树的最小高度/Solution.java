package BFS._111_二叉树的最小高度;

import java.util.LinkedList;
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

    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //初始化为1
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null){
                    return step;
                }
                if (cur.left!=null)
                    q.offer(cur.left);
                if (cur.right!=null)
                    q.offer(cur.right);
            }
            step++;
        }
        return step;
    }
}
