package 面试.去哪儿网;

import java.util.*;
import java.util.Map.Entry;

//给定一个数组，求数组中重复次数第K多的那个元素。
public class A {
    static int topK(int[] array, int k) {
        if (array.length == 0)
            return 0;
        if (k==0){
            return -1;
        }
        ArrayList<Entry<Integer, Integer>> res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        res = new ArrayList<>(map.entrySet());
        Collections.sort(res, new Comparator<Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        return res.get(k-1).getKey();

    }

    public static void main(String[] args) {
        int[] arr={1,1,2,2,1};
        int k = 1;
        int i = topK(arr, k);
        System.out.println(i);
    }
}
