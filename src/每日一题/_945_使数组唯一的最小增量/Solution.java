package 每日一题._945_使数组唯一的最小增量;

import java.util.Arrays;

public class Solution {
    public static int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int sum=0;
        for (int i = 1; i < A.length; i++) {
            while (A[i]<=A[i-1]){
                A[i]++;
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2};
        int ans = minIncrementForUnique(arr);
    }
}
