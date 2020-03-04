package 树._95_不同的搜索树II_mid;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 */
public class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    * 递归
    *
    *
     所以如果求 1...n 的所有可能。

    我们只需要把 1 作为根节点，[ ] 空作为左子树，[ 2 ... n ] 的所有可能作为右子树。

    2 作为根节点，[ 1 ] 作为左子树，[ 3...n ] 的所有可能作为右子树。

    3 作为根节点，[ 1 2 ] 的所有可能作为左子树，[ 4 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。

    4 作为根节点，[ 1 2 3 ] 的所有可能作为左子树，[ 5 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。

    ...

    n 作为根节点，[ 1... n ] 的所有可能作为左子树，[ ] 作为右子树。

    至于，[ 2 ... n ] 的所有可能以及 [ 4 ... n ] 以及其他情况的所有可能，可以利用上边的方法，把每个数字作为根节点，然后把所有可能的左子树和右子树组合起来即可。

    如果只有一个数字，那么所有可能就是一种情况，把该数字作为一棵树。而如果是 [ ]，那就返回 null。

]
    * */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        if (n == 0)
            return list;
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        for (int i = start; i <= end; i++) {
            //得到所有可能的左子树
            List<TreeNode> leftTrees = helper(start, i - 1);
            //得到所有可能的右子树
            List<TreeNode> rightTrees = helper(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree:rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left=leftTree;
                    root.right=rightTree;
                    list.add(root);
                }

            }
        }
        return list;
    }

    /*
    * 动态规划
    * 首先先看当len=n=1的情况 假设n=3
    * 当数字个数为0时 null
    * 当数字个数为1时 1，2，3  3种
    * 当数字个数为2时 [1,2] [2,3]  4种
    * 当数字个数为3时 [1,2,3]  5种
    * 所以求出len=1的可能，求出len=2的可能直到len=n;
    * 但是发现当len=2的时候有2种可能 但其结构都是相同 1-2 ，2-1
    *
    *
    * 举个例子。n = 100，此时我们求把 98 作为根节点的所有情况，根据之前的推导，我们需要长度是 97 的 [ 1 2 ... 97 ] 的所有情况作为左子树，
    * 长度是 2 的 [ 99 100 ] 的所有情况作为右子树。
    * [ 1 2 ... 97 ] 的所有情况刚好是 [ 1 2 ... len ] ，已经求出来了。但 [ 99 100 ] 怎么办呢？我们只求了 [ 1 2 ] 的所有情况。
    * 答案很明显了，在 [ 1 2 ] 的所有情况每个数字加一个偏差 98，即加上根节点的值就可以了。
    * */
    public List<TreeNode> generateTrees1(int n) {
        List<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return dp[0];
        }
        dp[0].add(null);
        //长度从1~n
        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<>();
            for (int root = 1; root <= len; root++) {
                //左子树的长度
                int leftLen = root - 1;
                //右子树的长度
                int rightLen = len - root;
                for (TreeNode leftTree : dp[leftLen]) {
                    for (TreeNode rightTree : dp[rightLen]) {
                        TreeNode treeRoot = new TreeNode(root);
                        treeRoot.left = leftTree;
                        //克隆右子树并且加上偏差
                        treeRoot.right = clone(rightTree, root);
                        dp[len].add(treeRoot);
                    }
                }

            }
        }
        return dp[n];
    }
    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }


    /*
    * 第一种方法的动态规划形式
    * */
    public List<TreeNode> generateTrees3(int n) {
        List<TreeNode> pre = new ArrayList<TreeNode>();
        if (n == 0) {
            return pre;
        }
        pre.add(null);
        //每次增加一个数字
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<TreeNode>();
            //遍历之前的所有解
            for (TreeNode root : pre) {
                //插入到根节点
                TreeNode insert = new TreeNode(i);
                insert.left = root;
                cur.add(insert);
                //插入到右孩子，右孩子的右孩子...最多找 n 次孩子
                for (int j = 0; j <= n; j++) {
                    TreeNode root_copy = treeCopy(root); //复制当前的树
                    TreeNode right = root_copy; //找到要插入右孩子的位置
                    int k = 0;
                    //遍历 j 次找右孩子
                    for (; k < j; k++) {
                        if (right == null)
                            break;
                        right = right.right;
                    }
                    //到达 null 提前结束
                    if (right == null)
                        break;
                    //保存当前右孩子的位置的子树作为插入节点的左孩子
                    TreeNode rightTree = right.right;
                    insert = new TreeNode(i);
                    right.right = insert; //右孩子是插入的节点
                    insert.left = rightTree; //插入节点的左孩子更新为插入位置之前的子树
                    //加入结果中
                    cur.add(root_copy);
                }
            }
            pre = cur;

        }
        return pre;
    }


    private TreeNode treeCopy(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = treeCopy(root.left);
        newRoot.right = treeCopy(root.right);
        return newRoot;
    }


}
