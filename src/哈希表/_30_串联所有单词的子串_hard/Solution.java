package 哈希表._30_串联所有单词的子串_hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        //获取数组长度
        int wordNum = words.length;
        if (wordNum == 0)
            return ans;
        //获取每个单词的长度
        int wordLength = words[0].length();
        //存所有单词
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String w : words
        ) {
            //意思就是当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }

        //遍历所有子串
        for (int i = 0; i < s.length() - wordLength * wordNum + 1; i++) {
            //存放遍历的字串
            HashMap<String, Integer> hashMap = new HashMap<>();
            int num = 0;
            while (num < wordNum) {
                //获取一个字符
                String word = s.substring(i + num * wordLength, i + (num + 1) * wordLength);
                //如果hashMap存在该字符
                if (allWords.containsKey(word)) {
                    int value = hashMap.getOrDefault(word, 0);
                    hashMap.put(word, value + 1);

                    if (hashMap.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                //如果该字符扫存在于allWords中并且描到的数量已经小于总的单词的数量 则增加记录的单词
                num++;
            }
            //如果所有单词都符合则记录该连续字符串开始的节点
            if (num == wordNum) {
                ans.add(i);
            }
        }
        return ans;
    }

    /*
     * 同样的思路另一种写法
     * */
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        //获取数组长度
        int wordNum = words.length;
        if (wordNum == 0)
            return ans;
        //获取每个单词的长度
        int wordLength = words[0].length();
        //滑动窗口总长度
        int allLen = wordLength * wordNum;
        //存所有单词
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String w : words
        ) {
            //意思就是当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }

        //遍历所有子串
        for (int i = 0; i < s.length() - allLen + 1; i++) {
            //存放遍历的字串
            HashMap<String, Integer> hashMap = new HashMap<>();
            String temp = s.substring(i, i + allLen);
            //步长为一个单词的长度
            for (int j = 0; j < temp.length(); j += wordLength) {
                String word = temp.substring(j, j + wordLength);
                hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
            }
            if (allWords.equals(hashMap))
                ans.add(i);
        }
        return ans;
    }

    /*
     * 将每个单词的长度作为一个步长
     * 每次移动一个单词的长度而不是一个字符的长度
     * */
    public static List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        //数组大小
        int wordNum = words.length;
        //每个单词的长度
        int wordLen = words[0].length();
        //总长度
        int allLen = wordNum * wordLen;
        if (wordNum == 0)
            return ans;
        //存放全部的单词
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String s1 : words
        ) {
            allWords.put(s1, allWords.getOrDefault(s1, 0) + 1);
        }
        //以每个单词的长度为步长控制
        for (int i = 0; i < wordLen; i++) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            int left = i, right = i, count = 0;
            while (right + wordLen < s.length()) {
                //获得第一个单词
                String temp = s.substring(right, right + wordLen);
                right += wordLen;
                //如果没有包含这个单词
                if (!allWords.containsKey(temp)) {
                    //放弃之前以添加的单词
                    left = right;
                    count = 0;
                    hashMap.clear();
                } else {
                    //如果包含这个单词那就在哈希表中值加1
                    hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
                    count++;
                }
                //如果添加的单词数超过匹配的数组中相同单词的数量
                //将前一个相同的单词删去 left右移
                if (hashMap.getOrDefault(temp,0)>allWords.getOrDefault(temp,0)) {
                    String t_w = s.substring(left,left+wordLen);
                    count--;
                    hashMap.put(t_w, hashMap.getOrDefault(t_w, 0) - 1);
                    left += wordLen;
                }
                if (count==wordNum)
                    ans.add(left);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> substring3 = findSubstring3(s, words);
        for (Integer a : substring3
        ) {
            System.out.println(a);
        }
    }
}
