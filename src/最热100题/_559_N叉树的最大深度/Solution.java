package 最热100题._559_N叉树的最大深度;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution {
    //递归
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            depth = Math.max(depth, maxDepth(root.children.get(i)));
        }
        return depth + 1;
    }

    //迭代法
    public int maxDepth1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        //在尾部加入元素
        if (root != null) queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                for (int j = 0; j < temp.children.size(); j++) {
                    if (temp.children.get(j) != null)
                        queue.offer(temp.children.get(j));
                }
            }
        }
        return depth;
    }
}
