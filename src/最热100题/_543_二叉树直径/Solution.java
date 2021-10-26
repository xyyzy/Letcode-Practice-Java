package 最热100题._543_二叉树直径;


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

    int res = 0;

    //最大直接就是根节点的左子树的最大深度+右子树的最大深度
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);// 左儿子为根的子树的深度
        int right = dfs(root.right);// 右儿子为根的子树的深度

        res = Math.max(res, left + right);

        return Math.max(left, right) + 1;// 返回该节点为根的子树的深度

    }
}
