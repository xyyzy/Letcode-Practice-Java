package 周赛._181_力扣周赛._5367_最长快乐前缀_字符串hash;

/**
 * 「快乐前缀」是在原字符串中既是 非空 前缀也是后缀（不包括原字符串自身）的字符串。
 * <p>
 * 给你一个字符串 s，请你返回它的 最长快乐前缀。
 * <p>
 * 如果不存在满足题意的前缀，则返回一个空字符串。
 */
public class Solution {
    /*
     * 暴力法内存溢出
     * */
    public static String longestPrefix(String s) {
        String ans = "";
        if (s == "" || s.length() == 1)
            return "";
        String[] pre = new String[s.length()];
        String[] aft = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            pre[i] = s.substring(0, i + 1);
        }
        for (int i = s.length(); i > 0; i--) {
            aft[i - 1] = s.substring(i - 1, s.length());
        }

        for (int i = 0; i < pre.length; i++) {
            int j = s.length() - 1 - i;
            if (pre[i].equals(aft[j]) && !pre[i].equals(s)) {
//                if (pre[i].compareTo(s) != 0)
                if (pre[i].length() > ans.length())
                    ans = pre[i];
            }
        }
        return ans;
    }
    /*
     * 字符串hash
     * */

    class StrHash {

        private static final long P = 805306457;
        private static final long MOD = (int) (1e9 + 7);
        private long[] hash;
        private long[] power;
        private char[] arr;

        public StrHash(char[] arr) {
            this.arr = arr;
            int len = arr.length;
            hash = new long[len];
            power = new long[len];
            calcHashAndPower();
        }

        private void calcHashAndPower() {
            hash[0] = arr[0];
            power[0] = 1;
            for (int i = 1; i < arr.length; i++){
                //计算每个的hash值
                hash[i] = (hash[i - 1] * P + arr[i]) % MOD;
                power[i] = (power[i - 1] * P) % MOD;
            }
        }

        private long getSubStrHash(int l, int r) {
            if (l == 0) {
                return hash[r];
            }
            return ((hash[r] - power[r - l + 1] * hash[l - 1]) % MOD + MOD) % MOD;
        }

    }

    public String longestPrefix1(String s) {
        char[] arr = s.toCharArray();
        StrHash strHash = new StrHash(arr);
        int len = arr.length;

        for (int i = len - 2; i >= 0; i--) {
            long prefix = strHash.getSubStrHash(0, i);
            long suffix = strHash.getSubStrHash(len - i - 1, len - 1);
            if (prefix == suffix) {
                return s.substring(0, i + 1);
            }
        }

        return "";

    }
        public static void main (String[]args){
            String str = "ababab";
            System.out.println(longestPrefix(str));
        }
    }
