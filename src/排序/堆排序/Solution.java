package 排序.堆排序;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 7, 6, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        //建堆
        heapInsert(arr);
        int size = arr.length;
        while (size > 1) {
            swap(arr, 0, size - 1);
            size--;
            //构造大根堆
            heapify(arr, 0, size);
        }
    }

    private static void heapInsert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //当前插入的索引
            int currentIndex = i;
            int fatherIndex = (currentIndex - 1) / 2;
            //如果当前插入的值大于其父结点的值,则交换值，并且将索引指向父结点
            //然后继续和上面的父结点值比较，直到不大于父结点，则退出循环
            while (arr[currentIndex] > arr[fatherIndex]) {
                swap(arr, currentIndex, fatherIndex);
                //将当前索引指向父索引
                currentIndex = fatherIndex;
                //重新计算索引
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }

    //将剩余的数构造成大根堆（通过顶端的数下降）
    private static void heapify(int[] arr, int index, int size) {
        //左右孩子
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < size) {
            int largestIndex;
            //判断孩子节点中比较大的值，要确保右孩子在size范围之内
            if (arr[left] < arr[right] && right < size) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }
            //比较父结点的值与孩子中较大的值，并确定最大值的索引,
            if (arr[index] > arr[largestIndex]) {
                largestIndex = index;
            }
            //如果父节点本身就是最大的索引值，则该子树就已经是大根堆了
            if (largestIndex == index) {
                break;
            }
            //父节点不是最大值
            swap(arr, index, largestIndex);
            //将索引指向孩子中较大的值的索引
            index = largestIndex;
            //重新计算交换之后的孩子的索引
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


}
