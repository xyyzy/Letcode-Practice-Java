package 最热100题._210_课程表II;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: TODO
 * @author: ares
 * @modified By: ares
 * @date: Created in 2021/7/20 21:07
 * @version:v1.0
 */
public class Solution {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        //构建邻接表
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }
        //入度数组
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            //入度为0的节点入队
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] res = new int[numCourses];
        // 当前结果集列表里的元素个数，正好可以作为下标
        int count = 0;

        while (!queue.isEmpty()) {
            Integer head = queue.poll();
            //入结果集
            res[count] = head;
            count++;
            HashSet<Integer> successors = adj[head];
            for (Integer successor : successors) {
                inDegree[successor]--;
                // 马上检测该结点的入度是否为 0，如果为 0，马上加入队列
                if (inDegree[successor] == 0) {
                    queue.offer(successor);
                }
            }
        }
        // 如果结果集中的数量不等于结点的数量，就不能完成课程任务，这一点是拓扑排序的结论
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = findOrder(4, arr);
        System.out.println(order);
    }
}
