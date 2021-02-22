package 最热100题._76_最小覆盖子串;

import java.util.HashMap;


/**
 * 滑动窗口
 * https://leetcode-cn.com/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/
 */
public class Solution {
    public String minWindow(String s, String t) {

        int[] need = new int[256];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0)
                count--;
            //把右边的字符加入窗口
            need[c]--;
            if (count == 0) {//窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放左边移动出窗口的字符
                    l++;//右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    start = l;
                    size = r - l + 1;
                }
                //计算完后重新开始循环，要求count不再满足count==0
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size==Integer.MAX_VALUE?"":s.substring(start,start+size);

    }
}
