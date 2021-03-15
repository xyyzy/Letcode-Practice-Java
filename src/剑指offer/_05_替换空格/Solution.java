package 剑指offer._05_替换空格;

public class Solution {
    /**
     * StringBuffer做
     * */
    public String replaceSpace(String s) {
        StringBuffer res = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c==' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }

    /**
     * java底层String是fianl  无法修改不能用原地修改算法
     * c++ 可以：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/solution/jian-zhi-offer-05-ti-huan-kong-ge-shuang-cgk3/
     * */
    public String replaceSpace1(String s) {
        String str = s.replace(" ","%20");
        return str;
    }

}
