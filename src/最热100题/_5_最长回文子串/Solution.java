package 最热100题._5_最长回文子串;

public class Solution {

    /**
     * 暴力法
     * */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        int maxlen = 0;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxlen && isPalindrome(charArray, i, j)) {
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }

    private boolean isPalindrome(char[] charArray, int i, int j) {
        while (i<j) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
