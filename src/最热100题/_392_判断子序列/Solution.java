package 最热100题._392_判断子序列;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            //两者都有匹配上的话，i++,j++
            if (s.charAt(i)==t.charAt(j)){
                i++;
            }
            //没匹配上就j++;
            j++;
        }
        return i==n;
    }
}
