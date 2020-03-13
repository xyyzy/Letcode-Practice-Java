package 树._103_二叉树的锯齿层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
        //
        node_queue.addLast(root);
        node_queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<Integer>();
        boolean is_order_left = true;
        while (!node_queue.isEmpty()) {
            //把第一个节点弹出
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                //判断是否是从左到右输出
                if (is_order_left)
                    // 从左到右输出  就在尾部添加
                    level_list.addLast(curr_node.val);
                else
                    // 从右到左输出  就在尾部添加
                    level_list.addFirst(curr_node.val);

                //增加一下层
                if (curr_node.left != null)
                    node_queue.addLast(curr_node.left);
                if (curr_node.right != null)
                    node_queue.addLast(curr_node.right);

            } else {
                //扫描完一层
                results.add(level_list);
                //每次扫描完一层重新开辟一个
                level_list = new LinkedList<Integer>();
                if (node_queue.size() > 0) {
                    node_queue.addLast(null);
                }
                //左右输出交替进行
                is_order_left = !is_order_left;
            }

        }
        return results;

    }

}
