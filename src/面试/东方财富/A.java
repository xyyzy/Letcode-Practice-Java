package 面试.东方财富;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class A {
    private static int n;
    private static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        ArrayList<String> path = new ArrayList<>();
        ArrayList<ArrayList<String>> paths = new ArrayList<>();
        int target = n;
        int count = 0;
        dfs(target, count, 1, path, paths);

    }

    private static void dfs(int target, int count, int index, ArrayList<String> path, ArrayList<ArrayList<String>> paths) {
        //剩余的值
        target -= index * index;
        count++;
        path.add(String.valueOf(index));
        dfs(target, count, index, path, paths);
        //到达最底层并且目标值为0
        if (count == k && target == 0) {
            paths.add(new ArrayList<>(path));
        }


    }


}
