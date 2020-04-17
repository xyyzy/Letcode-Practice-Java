package 树._117_填充每个节点的下一个右侧节点指针II;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

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

    /*
     * 层序遍历
     * */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                //如果不是最后一个节点
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

    /*
     *
     * */
    Node prev, leftmost;


    public Node connect1(Node root) {
        if (root == null)
            return null;

        //第一层只有一个节点初始化leftmost
        this.leftmost = root;
        //curr始终接收最左侧节点,用于记录当前层的节点
        Node curr = leftmost;
        // 如果不是最后一层就一直在循环中
        while (this.leftmost != null) {
            //初始化prev，prev用于遍历下次全部节点，将其链接起来
            this.prev = null;
            curr = this.leftmost;
            //用于始终指向最左侧节点，此处赋值为null用于到达最后一层时跳出循环
            this.leftmost = null;
            while (curr != null) {
                processChild(curr.left);
                processChild(curr.right);
                curr = curr.next;
            }
        }
        return root;
    }

    private void processChild(Node childNode){
        if (childNode!=null){

            if (this.prev!=null){
                //非第一次到达下次层，之后进入的节点全部最为前一个节点的子节点
                this.prev.next = childNode;
            }else {
                // 当第一次到达下一层时，节点prev为空
                //第一次进来的childnode将其赋值为leftmost
                this.leftmost = childNode;
            }
            //改变prev的指向
            //将第一次进来的childnode赋值给prev
            this.prev = childNode;
        }
    }
}
