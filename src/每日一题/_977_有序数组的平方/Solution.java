package 每日一题._977_有序数组的平方;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) Math.pow(A[i],2);
        }
        Arrays.sort(A);
        return A;
    }
}
