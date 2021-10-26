package 面试.友塔游戏;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        //卡牌数量
        int n = Integer.parseInt(s1[0]);
        //战队卡牌数量上限
        int max_count = Integer.parseInt(s1[1]);
        //战队卡牌cost上限
        int max_cost = Integer.parseInt(s1[2]);
        //cost
        int[] c = new int[n];
        //power
        int[] p = new int[n];
        String str = sc.nextLine();
        String[] s2 = str.split(" ");
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(s2[i * 2]);
        }
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(s2[i * 2 + 1]);
        }

//        int[][] dp = new int[n + 1][max_cost + 1];
//
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = 0;
//        }
//        for (int i = 0; i <= max_cost; i++) {
//            dp[0][i] = 0;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = c[i - 1]; j <= max_cost; j++) {
//                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i - 1]] + p[i - 1]);
//            }
//        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(c[i], p[i]);
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        int max = 0;
        int num = 0;
        for (int i = 0; i <list.size()-1; i++) {
            int tempCost = 0;
            int tempMax = 0;
            for (int j = i; j < i + max_count; j++) {
                tempCost += list.get(j).getKey();
                if (tempCost > max_cost) {
                    break;
                }
                tempMax += list.get(j).getValue();
                max = Math.max(tempMax, max);
            }
        }

        System.out.println(max);
        //System.out.println(dp[n][max_cost]-dp[n-max_count+1][max_cost]);
    }
}
