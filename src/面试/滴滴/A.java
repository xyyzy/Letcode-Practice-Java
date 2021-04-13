package 面试.滴滴;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 优秀的操作系统离不开优秀的任务调度算法。现在，有一台计算机即将执行n个任务，
 * 每个任务都有一个准备阶段和执行阶段。只有在准备阶段完成后，执行阶段才可以开始。同一时间，
 * 计算机只能执行一个任务的执行阶段，同时可以执行任意多个任务的准备阶段。请你设计一个算法，
 * 合理分配任务执行顺序，并输出完成所有任务的最少时间。
 * <p>
 * <p>
 * 第一行一个整数n表示任务的数量（1<=n<=5*10^4）
 * <p>
 * 接下来n行每行两个整数a，b表示第i个任务的准备时长和执行时长。（1<=a,b<=10^9）
 * <p>
 * 2
 * 5 1
 * 2 4
 * <p>
 * <p>
 * 7
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s3 = sc.nextLine();
        String[] s2 = s3.split(" ");
        int n = Integer.parseInt(s2[0]);

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            temp.add(Integer.parseInt(s1[0]));
            temp.add(Integer.parseInt(s1[1]));
            arr.add(temp);
        }
        Collections.sort(arr, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });
        int i =0;
        ArrayList<int[]> ans = new ArrayList<>();
        while (i<arr.size()){
            int left = arr.get(i).get(0);
            int right = arr.get(i).get(1)+left;
            //包含或者连续的情况
            while ( i < arr.size() - 1&&( arr.get(i + 1).get(0) <= right || arr.get(i+1).get(0)-1==right)) {
                right = Math.max(arr.get(i).get(1),right+arr.get(i+1).get(1));
                i++;

            }
            ans.add(new int[]{left,right});
            //System.out.println(String.valueOf(left) + '-'+ String.valueOf(right));
            i++;
        }
        int[] ints = ans.get(ans.size() - 1);
        int num = ints[1];
        System.out.println(num);
    }
}
