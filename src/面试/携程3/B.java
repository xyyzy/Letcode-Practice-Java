package 面试.携程3;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> times = new ArrayList<>();
        String s = sc.nextLine();
        String stars = sc.nextLine();
        String ends = sc.nextLine();
        String[] s2 = stars.split(" ");
        String[] s1 = ends.split(" ");
        if (s2.length == 0 || s1.length == 0)
            System.out.println(0);
        for (int j = 0; j < n; j++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(Integer.parseInt(s2[j]));
            temp.add(Integer.parseInt(s1[j]));
            times.add(temp);
        }
        String s3 = sc.nextLine();
        String[] s4 = s3.split(" ");
        //保存时间和价格对应
        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(times.get(i), Integer.parseInt(s4[i]));
        }
        //排序
        ArrayList<Map.Entry<ArrayList<Integer>, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<ArrayList<Integer>, Integer>>() {
            @Override
            public int compare(Map.Entry<ArrayList<Integer>, Integer> o1, Map.Entry<ArrayList<Integer>, Integer> o2) {
                return o1.getKey().get(0) - o2.getKey().get(0);
            }
        });
        int[] dp = new int[n + 1];
        dp[1] = list.get(0).getValue();
        int index = 0;
        for (int i = 2; i <= n; i++) {
            //如果后一个开始时间等于前一个的开始时间比较两者的价值
            if (list.get(i - 1).getKey().get(0) == list.get(i - 2).getKey().get(0)) {
                dp[i] = Math.max(dp[i - 2] + list.get(i - 2).getValue(), dp[i - 2] + list.get(i - 1).getValue());
            }
            //后一个的开始时间小于前一个结束时间，比较两者的价值
            else if (list.get(i - 1).getKey().get(0) < list.get(i - 2).getKey().get(1)) {
                dp[i] = Math.max(dp[i - 2] + list.get(i - 2).getValue(), dp[i - 2] + list.get(i - 1).getValue());
            }
            //如果后一个的结束时间小于前一个的结束时间
            else if (list.get(i - 1).getKey().get(1) <= list.get(i - 2).getKey().get(1)) {
                dp[i] = Math.max(dp[i - 2] + list.get(i - 2).getValue(), dp[i - 2] + list.get(i - 1).getValue());
            }
            //如果当前时间大于前一个的结束时间
            else if (list.get(i - 1).getKey().get(0) >= list.get(i - 2).getKey().get(1)) {
                dp[i] = dp[i - 1] + list.get(i - 1).getValue();
            }

        }
        System.out.println(dp[n]);

    }
    /*
    * 5
1 2 3 3 5
3 4 5 6 7
200 150 180 210 500
    * */
}
