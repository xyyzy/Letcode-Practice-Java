package BFS._107_二叉树的层次遍历II;

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //返回结果
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        //保存节点用于遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //保存每一层的遍历结果
            List<Integer> curLevel = new LinkedList<>();
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                curLevel.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            //始终在加入头节点
            result.add(0, curLevel);
        }
        return result;
    }
}
