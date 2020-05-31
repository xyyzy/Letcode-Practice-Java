package BFS._599_N叉树最大深度;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class Solution {
    /*
    * BFS 效率低
    * */
    public int maxDepth1(Node root) {
        if (root==null)
            return 0;
        Queue<Node> queue =new LinkedList<>();
        queue.offer(root);
        int depth =0;
        while (!queue.isEmpty()){
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Node cur = queue.poll();
                for (int j = 0; j < cur.children.size(); j++) {
                    if (cur.children.get(j)!=null)
                        queue.add(cur.children.get(j));
                }
            }
            depth++;
        }
        return depth;
    }
    /*
    * DFS
    * */
    public int maxDepth2(Node root) {
        if (root==null)
            return 0;
        int max=0;
        //求出每个子树的最大深度
        for (Node node:root.children) {
            int depth = maxDepth2(node);
            max = Math.max(depth,max);
        }
        return max+1;
    }

}
