package 树._116_填充每个节点的下一个右侧节点指针;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        //迭代树的层级
        while (queue.size() > 0) {
            int size = queue.size();
            //在一层内迭代
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                if (i < size - 1) {
                    temp.next = queue.peek();
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return root;
    }

    /**
     * 通过已经有next节点关系建立不需要额外的空间
     * 有2种next关系
     * 1.第一种情况两个子节点属于同一个父节点，因此直接通过父节点建立两个子节点的 next 指针即可
     * 2.第二种情况是连接不同父节点之间子节点的情况。更具体地说，连接的是第一个父节点的右孩子和第二父节点的左孩子。
     * 由于已经在父节点这一层建立了 next 指针，因此可以直接通过第一个父节点的 next 指针找到第二个父节点，
     * 然后在它们的孩子之间建立连接。
     */
    public Node connect1(Node root) {
        if (root == null)
            return null;
        Node leftmost = root;
        //因为是完美二叉树，只需判断左节点是否存在
        while (leftmost.left != null) {
            //temp用于遍历一层的全部节点
            Node temp = leftmost;
            while (temp != null) {
                //第一种情况
                temp.left.next = temp.right;
                //第二种情况
                if (temp.next!=null){
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }
            //始终指向最左端
            leftmost = leftmost.left;
        }
        return root;
    }
}
