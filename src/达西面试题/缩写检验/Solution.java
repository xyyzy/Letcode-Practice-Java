package 达西面试题.缩写检验;

/**
 * 给定⼀个⾮空字符串 s 和⼀个缩写 abbr，请校验它们是否匹配。 假设字符串
 * 中只包含⼩写字⺟，缩写中只包含⼩写字⺟和数字。缩写中的数字 表示其缩略
 * 的字符数；连续多位数字表示⼀个多位数。
 * 例如，字符串 “word” 的缩写有且仅有以下这些：[“word", “1ord”, “w1rd”,
 * “wo1d”, “wor1”, “2rd”, “w2d”, “wo2”, “1o1d”, “1or1”, “w1r1”, “1o2”, “2r1”,
 * “3d”, “w3”, “4"]。
 */
public class Solution {
    public boolean valid(String word, String abbr) {
        int i = 0, j = 0, n = 0;
        while (i < word.length() && j < abbr.length()) {
            n = 0;
            if (abbr.charAt(j) == '0') {
                return false;
            }
            //如果匹配字符的不是字母则word的游标i移动j所对应的长度
            while (j < abbr.length() && !Character.isLetter(abbr.charAt(j))) {
                n = n * 10 + abbr.charAt(j++) - '0';
            }
            i = i + n;
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
