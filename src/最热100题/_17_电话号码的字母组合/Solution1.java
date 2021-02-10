package 最热100题._17_电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;


/**
 * 队列思想
 */
public class Solution1 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        String[] letter_map = {
                " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        ArrayList<String> res = new ArrayList<>();
        //先往队列中加入一个空字符
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            //由当前遍历到的字符，取字典表中查找对应的字符串
            String letters = letter_map[digits.charAt(i) - '0'];
            int size = res.size();
            for (int j = 0; j < size; j++) {
                String remove = res.remove(0);
                //然后跟"def"这样的字符串拼接，并再次放到队列中
                for (int k = 0; k < letters.length(); k++) {
                    res.add(remove + letters.charAt(k));
                }
            }
        }
        return res;
    }
}
