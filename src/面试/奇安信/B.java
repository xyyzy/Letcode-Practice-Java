package 面试.奇安信;

import java.util.Scanner;

public class B {

    static final int MX = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //顶点数目
        int n = sc.nextInt();
        //起点和终点
        int start = sc.nextInt();
        int end = sc.nextInt();

        int[][] matrix = new int[n][n];


        while (true) {
            int i = sc.nextInt();
            int i1 = sc.nextInt();
            int i3 = sc.nextInt();

            if (i == 0 && i1 == 0 && i3 == 0)
                break;
            else
                matrix[i][i1] = i3;
        }

        get(matrix, n, start, end);
    }


    private static void get(int[][] matrix, int n, int b, int e) {
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
            distance[i] = MX;
        }
        visited[b] = true;
        distance[b] = 0;

        int cur = b;
        int nextP = -1;
        int times = 0;
        while (cur != e && times < (n - 1)) {
            int minL = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (visited[j])
                    continue;
                if (distance[cur] + matrix[cur][j] < distance[j]) {
                    distance[j] = distance[cur] + matrix[cur][j];
                }
                if (distance[j] < minL) {
                    minL = distance[j];
                    nextP = j;
                }
            }
            visited[nextP] = true;
            cur = nextP;
            times++;
        }
        System.out.println(distance[e] == MX ? -1 : distance[e]);
    }
}
