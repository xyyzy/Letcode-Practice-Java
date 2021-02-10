package 最热100题._17_电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(res, map, digits, 0, new StringBuffer());
        return res;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        //递归到最后一个
        if (index==digits.length())
            combinations.add(combination.toString());
        else {
            char temp = digits.charAt(index);
            String letters = phoneMap.get(temp);
            int length = letters.length();
            for (int i = 0; i < length; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations,phoneMap,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        String digits="23";
        List<String> res = letterCombinations(digits);
        for (String re : res) {
            System.out.println(re);
        }
    }


}
