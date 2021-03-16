package 剑指offer._11_旋转数组的最小数字;

public class Solution {
    //二分法可以用于半有序的数组
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            //说明m在左排序中 最小值 在右排序中
            if (numbers[m]>numbers[j]) i = m+1;
            //说明m在右排序中 最小值 在左排序中
            else if (numbers[m]<numbers[j]) j = m;
            // num[m] = num[j]
            else j--;
        }
        return numbers[i];
    }
}
