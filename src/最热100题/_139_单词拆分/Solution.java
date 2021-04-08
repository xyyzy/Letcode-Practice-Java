package 最热100题._139_单词拆分;

import java.util.HashSet;
import java.util.List;

public class Solution {

    //最优解：dp
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i] 表示以i结尾的子字符串是否可以拆分为字典内的单词
        //对所有的0<=j<=i 可以将原字符串划分为[0,j],[j+1,i]
        //如果有dp[j] == true 则[0,j]可以拆分，只需考虑[j+1,i]
        //dp[i] = dictSet.contains(s.substring(j+1,i+1))? true:false;
        //只要有一个j满足，就为true
        int len = s.length();
        //可以直接有list创建set
        HashSet<String> set = new HashSet<>();
        //将dict存入set，并记录最大长度
        int maxLen = 0;
        for (String s1 : wordDict) {
            maxLen = Math.max(maxLen, s1.length());
            set.add(s1);
        }
        //增加一位，dp[0]表示j为空字符串。避免开头的-1坐标讨论
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        //上一个匹配的位置
        int last = -1;
        for (int i = 0; i < len; i++) {
            //如果匹配长度超过最大长度
            if (i - last > maxLen)
                return false;
            //j多一位，j = i时，表示只有s.charAt(i)一个字符
            //未匹配的字符最多只能有maxLen的长度, 所以j的起点为i + 1 - manLen（不小于0）,可以节省时间
            for (int j = Math.max(i + 1 - maxLen, 0); j < i + 1; j++) {
                //substring区间是左闭右开 所以要从j到i+1
                if (dp[j] && set.contains(s.substring(j, i + 1))) {
                    //满足条件拆分
                    dp[i + 1] = true;
                    last = i;
                    break;
                }
            }
        }
        return dp[len];
    }

    //记忆回溯(非优化) 会超时
    public boolean wordBreak1(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return backtrack(s, set);
    }

    private boolean backtrack(String s, HashSet<String> set) {
        if (s.length() == 0) return true;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.substring(0, i + 1))) {
                if (backtrack(s.substring(i + 1), set)) return true;
            }
        }
        return false;
    }


    //利用visited数组当作记忆集做优化
    boolean[] vistied;

    public boolean wordBreak2(String s, List<String> wordDict) {
        this.vistied = new boolean[s.length()];
        HashSet<String> set = new HashSet<>(wordDict);
        return backtrack(s, 0, set);
    }

    private boolean backtrack(String s, int start, HashSet<String> set) {
        if (s.length() == 0) return true;
        //如果已经访问过 返回
        if (vistied[start]) return false;
        for (int i = 0; i < s.length(); i++) {
            //先匹配  0,i+1
            if (set.contains(s.substring(0,i+1))){
                //在匹配 i+1,..
                if (backtrack(s.substring(i+1),start+i+1,set)) return true;
            }
        }
        vistied[start] = true;
        return false;
    }
}
