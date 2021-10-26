package 面试.奇安信;

import java.util.Arrays;
import java.util.Comparator;

public class A {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 最大牛奶桶数
     *
     * @param grass int整型一维数组 吃的草的捆数
     * @param milk  int整型一维数组 产的牛奶桶数
     * @return int整型
     */
    public static int MaxMilk(int[] grass, int[] milk) {
        int m = grass.length;
        int[][] items = new int[m][2];
        for (int i = 0; i < m; i++) {
            items[i] = new int[]{grass[i], milk[i]};
        }
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) return 1;
                else if (o1[0] < o2[0]) return -1;
                else {
                    if (o1[1] > o2[1]) return 1;
                    else if (o1[1] == o2[1]) return 0;
                    else return -1;
                }
            }
        });
        //res保存最长递增子序列的大小。
        int res = 1;
        //用来保存每个长度末尾的Y尽可能小的[x,y]数组。
        int[][] dp = new int[m + 1][2];
        int max = 0;
        dp[1] = items[0];
        max += dp[1][1];
        for (int j = 1; j < m; j++) {
            if (dp[res][1] <= items[j][1]) {
                dp[++res] = items[j];
                max += dp[res][1];
            } else if (dp[res][1] > items[res][1]) {
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
                if (dp[pos][0] != items[j][0]){
                    dp[pos + 1] = items[j];
                }

            }

        }
        int count = 0;
//        for (int[] ints : dp) {
//            count += ints[1];
//        }
//        System.out.println(count);
        return max;
    }

    public static void main(String[] args) {
        int[] grass1 = {2, 3, 4, 5, 6};
        int[] mikes1 = {2, 4, 7, 9, 12};

        int[] grass2 = {5, 5, 5, 5, 5};
        int[] mikes2 = {1, 5, 3, 4, 2};

        int[] grass3 = {1, 3, 2, 7, 5};
        int[] mikes3 = {3, 3, 3, 3, 3};

        int[] grass4 = {5, 5, 5, 5, 5};
        int[] mikes4 = {3, 3, 3, 3, 3};

        int[] grass5 = {3, 5, 8, 2};
        int[] mikes5 = {2, 3, 5, 7};

        int[] grass6 = {2, 3, 5, 8, 3};
        int[] mikes6 = {1, 2, 3, 5, 4};

        System.out.println(MaxMilk(grass5, mikes5));
    }
}
