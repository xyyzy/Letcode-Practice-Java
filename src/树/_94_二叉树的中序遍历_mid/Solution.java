package 树._94_二叉树的中序遍历_mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
     * 递归
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);

    }


    /*
     *  栈的迭代
     * */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            stack.push(curr.right);
        }
        return list;
    }


    /*
     * 莫里斯遍历
     *
     * 我们知道，左子树最后遍历的节点一定是一个叶子节点，它的左右孩子都是 null，我们把它右孩子指向当前根节点存起来，这样的话我们就不需要额外空间了。这样做，遍历完当前左子树，就可以回到根节点了。

    当然如果当前根节点左子树为空，那么我们只需要保存根节点的值，然后考虑右子树即可。

    所以总体思想就是：记当前遍历的节点为 cur。

    1、cur.left 为 null，保存 cur 的值，更新 cur = cur.right

    2、cur.left 不为 null，找到 cur.left 这颗子树最右边的节点记做 last

    2.1 last.right 为 null，那么将 last.right = cur，更新 cur = cur.left

    2.2 last.right 不为 null，说明之前已经访问过，第二次来到这里，表明当前子树遍历完成，保存 cur 的值，更新 cur = cur.right
     * */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        if (current==null)
            return list;
        while (current != null) {
            //如果其左子树为空直接跳转到右子树上
            if (current.left == null) {
                list.add(current.val);
                current = current.right;
            } else {
                //将pre赋值为current的左节点
                TreeNode pre = current.left;
                while (pre.right != null&&pre.right!=current) {
                    //找到current最右边的节点
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }
                if (pre.right == current) {
                    //恢复成null
                    pre.right = null;
                    list.add(current.val);
                    current = current.right;
                }

            }
        }
        return list;
    }

    /*
     * 颜色分块法
     * */
    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node, String color) {
            this.node = node;
            this.color = color;
        }
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        List<Integer> list = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));

        while (!stack.isEmpty()) {
            ColorNode cn = stack.pop();
            if (cn.color.equals("white")) {
                //找右节点
                if (cn.node.right != null) {
                    stack.push(new ColorNode(cn.node.right, "white"));
                }
                //将其改为已访问过
                stack.push(new ColorNode(cn.node, "gray"));
                if (cn.node.left != null) {
                    stack.push(new ColorNode(cn.node.left, "white"));
                }
            } else {
                list.add(cn.node.val);
            }
        }
        return list;
    }
}
