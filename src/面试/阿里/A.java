package 面试.阿里;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //n组数据
        String str = bf.readLine();
        int n = Integer.parseInt(str);
        for (int i = 0; i < n; i++) {
            //每组元素中的个数
            String str1 = bf.readLine();
            int m = Integer.parseInt(str1);
            String[] str2 = bf.readLine().split(" ");
            String[] str3 = bf.readLine().split(" ");
            int[][] items = new int[m][2];
            for (int j = 0; j < m; j++) {
                items[j] = new int[]{Integer.parseInt(str2[j]), Integer.parseInt(str3[j])};
            }
            Arrays.sort(items, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] > o2[0]) return 1;
                    else if (o1[0] < o2[0]) return -1;
                    else {
                        if (o1[1] > o2[1]) return -1;
                        else if (o1[1] == o2[1]) return 0;
                        else return 1;
                    }
                }
            });
            //res保存最长递增子序列的大小。
            int res = 1;
            //用来保存每个长度末尾的Y尽可能小的[x,y]数组。
            int[][] dp = new int[m + 1][2];
            dp[1] = items[0];
            //二分法进行查找此时的Y刚刚好大于哪一个下标的Y，又小于下一个下标的Y，这样更改下一个下标
            //的Y，为此时的Y，就可以保证dp数组保存的是末尾可能的最小的Y。这种方法相对于DP寻找最长
            //递增子序列，更快，时间复杂度为O(nlogn)
            for (int j = 1; j < m; j++) {
                if (dp[res][1] < items[j][1]) dp[++res] = items[j];
                else if (dp[res][1] > items[res][1]) {
                    int l = 1, r = res, pos = 0;
                    //二分查找
                    while (l <= r) {
                        int mid = (l + r) >> 1;
                        if (dp[mid][1] < items[j][1]) {
                            pos = mid;
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }
                    if (dp[pos][0] != items[j][0])
                        dp[pos+1] = items[j];
                }

            }
            System.out.println(res);
        }
    }
}
