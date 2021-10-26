package 最热100题.岛屿问题._827_填海造陆问题;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
public class Solution {
    public int largestIsland(int[][] grid) {
        if (grid == null)
            return 1;
        int res = 0;
        int index = 2;
        HashMap<Integer, Integer> indexAndAreas = new HashMap<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                //如果是陆地
                if (grid[r][c] == 1) {
                    //计算一块陆地的面积
                    int area = area(grid, r, c, index);
                    indexAndAreas.put(index, area);
                    index++;
                    //最大面积
                    res = Math.max(res, area);
                }
            }
        }
        System.out.println(res);
        //如果没有陆地，那么就造1块
        if (res == 0) return 1;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {//遍历海洋格子
                    HashSet<Integer> hashSet = findNeighbour(grid, r, c);//把上下左右四邻放入set里，set的目的是去重
                    //周围没有陆地就不必再继续算了，所以continue
                    if (hashSet.size() < 1) continue;
                    int twoIsland = 1;//起始是1，直接把我们造出来的1计算进去
                    for (Integer i : hashSet) {
                        twoIsland += indexAndAreas.get(i);//通过序号找到面积
                    }
                    res = Math.max(res,twoIsland);

                }
            }
        }
        return res;
    }

    private HashSet<Integer> findNeighbour(int[][] grid, int r, int c) {
        HashSet<Integer> hashSet = new HashSet<>();
        //在地图中，且是陆地
        if (inArea(grid, r - 1, c) && grid[r - 1][c] != 0)
        hashSet.add(grid[r - 1][c]);
        if (inArea(grid, r + 1, c) && grid[r + 1][c] != 0)
            hashSet.add(grid[r + 1][c]);
        if (inArea(grid, r, c - 1) && grid[r][c - 1] != 0)
            hashSet.add(grid[r][c - 1]);
        if (inArea(grid, r, c + 1) && grid[r][c + 1] != 0)
            hashSet.add(grid[r][c + 1]);

        return hashSet;
    }

    //计算一块陆地的面积
    private int area(int[][] grid, int r, int c, int index) {
        if (!inArea(grid, r, c)) return 0;
        if (grid[r][c] != 1) return 0;
        grid[r][c] = index;
        return 1 + area(grid, r - 1, c, index) + area(grid, r + 1, c, index) + area(grid, r, c - 1, index) + area(grid, r, c + 1, index);
    }


    private boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }


}
