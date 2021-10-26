package 面试.明略科技;

public class A {
    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound_(int n, int v, int[] a) {
        int left =0;
        int right = n-1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            //大于目标值的情况
            if (a[mid] >= v) {
                //考虑 元素不在数组中,且元素中所有元素都比target大
                if (mid == 0 || a[mid - 1] < v) {
                    return mid+1;
                } else {
                    right = mid - 1;
                }
            } else if (a[mid] < v) {
                left = mid +1;
            }
        }
        //所有元素都小于目标元素
        return n+1;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,4,5,6,7};
        int i = upper_bound_(arr.length, 4, arr);
        System.out.println(i);
    }

}
