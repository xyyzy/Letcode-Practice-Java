package 面试.便利蜂;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.Integer.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        int[][] arr = new int[split.length][1];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String temp = split[i];
            String[] split1 = temp.split("-");
            ArrayList<Integer> s1 = new ArrayList<>();
            for (int j = 0; j < split1.length; j++) {
                s1.add(Integer.valueOf(split1[j]));
            }
            res.add(s1);
        }
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        StringBuilder sb = new StringBuilder();

        ArrayList<int[]> ans = new ArrayList<>();
        int i = 0;
        while (i < res.size()) {
            int left = res.get(i).get(0);
            int right = res.get(i).get(1);
            //包含或者连续的情况
            while ( i < res.size() - 1&&( res.get(i + 1).get(0) <= right || res.get(i+1).get(0)-1==right)) {
                i++;
                right = Math.max(res.get(i).get(1),right);
            }
            //ans.add(new int[]{left,right});
            //System.out.println(String.valueOf(left) + '-'+ String.valueOf(right));
            sb.append(String.valueOf(left) + '-'+ String.valueOf(right)+',');
            i++;
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
