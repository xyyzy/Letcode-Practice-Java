package DFS._129_求根到叶子节点数字之和;

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

    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    public int helper(TreeNode root, int i) {
        if (root==null) return 0;
        int temp = i*10+root.val;
        if (root.left == null && root.right == null)
            return temp;
        return helper(root.left, temp) + helper(root.right, temp);

    }
}
