package 最热100题._49_字母异位词分组;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            //返回value 没有的返回一个new 的list
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
}
