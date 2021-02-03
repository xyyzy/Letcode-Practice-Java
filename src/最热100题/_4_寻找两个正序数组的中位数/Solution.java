package 最热100题._4_寻找两个正序数组的中位数;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] res = new int[l1 + l2];
        for (int i = 0; i < l1; i++) {
            res[i] = nums1[i];
        }
        for (int i = 0; i < l2; i++) {
            res[l1 + i] = nums2[i];
        }
        Arrays.sort(res);
        if (res.length%2!=0){
            return res[res.length/2];
        }
        else {
            double num =res[res.length/2-1]+res[res.length/2];
            return num/2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
