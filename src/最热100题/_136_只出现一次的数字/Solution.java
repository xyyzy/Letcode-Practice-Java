package 最热100题._136_只出现一次的数字;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    /**
     * 利用hash
     * time O(n)
     * space O(n)
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            //如果没有的话为1，已经有的话+1
            count = count == null ? 1 : count + 1;
            map.put(num, count);
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1)
                return integer;
        }
        return -1;
    }

    /**
     * 利用异或的结合律 和 任何数和自己异或都是0的性质
     */
    public int singleNumber1(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^=num;
        }
        return res;
    }

}
