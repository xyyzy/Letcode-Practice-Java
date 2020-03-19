package 哈希表._49_异位词分组_mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str: strs
             ) {
            //转换排序后再转成string
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String find = new String(s);
            //排序后的为键
            if (map.containsKey(find)){
                //获得对应的值
                List<String> arr = map.get(find);
                //增加相同的元素
                arr.add(str);
                map.put(find,arr);
            }else{
                List<String> arr = new ArrayList<>();
                arr.add(str);
                map.put(find,arr);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

    }
}
