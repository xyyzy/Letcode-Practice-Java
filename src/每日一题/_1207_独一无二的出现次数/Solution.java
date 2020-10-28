package 每日一题._1207_独一无二的出现次数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        //Hashset中的元素不能重复
        return map.size() == new HashSet<>(map.values()).size();
    }

    //先计算每个数出现的次数，再逐步存放到集合中，判断是否存放成功
    public boolean uniqueOccurrences1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int value : map.values()) {
            //添加重复的值会报错
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }
}
