package 最热100题._104_二叉树的最大深度;

import java.util.*;

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
     * 递归
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    /**
     * 迭代  层序遍历
     *  Queue<TreeNode> queue = new LinkedList<>();
     *  queue.offer()在队列尾部加数据  === stack.addLast()
     */
    public int maxDepth1(TreeNode root) {
        if (root == null)
            return 0;
        int max =0;
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);
        while (!stack.isEmpty()){
            max++;
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = stack.pop();
                if (temp.left!=null)
                    stack.addLast(temp.left);
                if (temp.right!=null)
                    stack.addLast(temp.right);
            }
        }

        return max;
    }


}
