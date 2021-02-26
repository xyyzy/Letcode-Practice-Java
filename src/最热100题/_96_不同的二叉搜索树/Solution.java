package 最热100题._96_不同的二叉搜索树;

public class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * G[i]  表示长度为i的二叉搜索树的种类个数
     * F(i,n)  表示以i为根节点长度为n构建的二叉树种类
     *
     * */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];

    }
}
