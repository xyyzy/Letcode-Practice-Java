package 最热100题._207_课程表;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: TODO
 * @author: ares
 * @modified By: ares
 * @date: Created in 2021/7/21 15:09
 * @version:v1.0
 */
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //邻接表
        List<List<Integer>> adj = new ArrayList<>();
        //入度数组
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        //(1,0)---->   0->1
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }

        int res = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int head = queue.poll();
            numCourses--;
            for (int cur : adj.get(head)) {
                //入度减1为0则入队
                if (--inDegree[cur]==0)
                    queue.add(cur);
            }
        }
        return  numCourses==0;
    }

}
