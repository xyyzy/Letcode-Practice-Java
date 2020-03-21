package 每日一题.M40_最小的K个数;

import java.util.Arrays;

/**
 *
 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * */
public class Soltuion {
    public int[] getLeastNumbers(int[] arr, int k) {
        int [] ans = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i <k ; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }
}
