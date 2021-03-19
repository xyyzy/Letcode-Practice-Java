package 剑指offer._26_树的子结构;


class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 解法1  利用先序遍历的思想
     * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));

    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    /**
     * DFS
     */


    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        boolean res = false;
        if (A == null || B == null)
            return false;
        if (A.val == B.val && isSubTreeHelper(A, B)) {
            res = true;
        }
        //dfs递归查找A的子节点是否包含B的结构
        res = res || isSubStructure1(A.left, B) || isSubStructure1(A.right, B);
        return res;

    }


    /**
     * 判断是否为子结构
     */
    public boolean isSubTreeHelper(TreeNode A, TreeNode B) {
        if (A == null && B != null)
            return false;
        if (B == null)
            return true;
        return A.val == B.val && isSubTreeHelper(A.left, B.left) && isSubTreeHelper(A.right, B.right);
    }

}