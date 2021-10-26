package 面试.华控;

import javafx.print.Collation;

import java.util.*;

public class B {
    //无序数组 里面的数字会重复若干次，找到出现次数最多的k个数 求和
    //
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        int k = 2;
        List<Integer> integers = get(arr, k);
        System.out.println(Arrays.toString(new List[]{integers}));

    }

    public static List<Integer> get(int arr[], int k) {
        List<Integer> res = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int temp = map.getOrDefault(arr[i], 0) + 1;
            map.put(arr[i], temp);
        }
        int length = map.size();
        Map.Entry<Integer, Integer>[] entries = new Map.Entry[length + 1];
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        for (int i = 1; i <= entries.length; i++) {
            entries[i] = iterator.next();
        }

        //构造
        for (int i = length / 2; i >= 1; i--) {
            help(entries,length,i);
        }
        for (int i = 1; i <=k ; i++) {
            res.add(entries[1].getKey());
            entries[1] = entries[length];
            length--;
            help(entries,length,1);
        }
        return res;
    }

    public static void help(Map.Entry<Integer, Integer>[] entries, int len, int i) {
        //头尾交换
        entries[0] = entries[i];
        for (int j = i * 2; j <= len; j *= 2) {
            //找到孩子节点中最大的
            if (j + 1 <= len && entries[j].getValue() < entries[j + 1].getValue()) {
                j = j + 1;
            }
            if (entries[0].getValue() < entries[j].getValue()) {
                Map.Entry<Integer, Integer> entry = entries[0];
                entries[0] = entries[j];
                entries[j] = entry;
            } else break;
        }
    }

}
