package 剑指offer._20_表示数值的字符串;

public class Solution {
    //全局性索引
    private int index = 0;

    //返回值表示当前部分有无符号数
    private boolean scanUnsignedInteger(String str) {
        //是否包含无符号数
        int before = index;
        while (str.charAt(index) >= '0' && str.charAt(index) <= '9')
            index++;
        return index > before;
    }


    private boolean scanInteger(String str) {
        //是否包含有符号数
        if (str.charAt(index) == '+' || str.charAt(index) == '-')
            index++;
        return scanUnsignedInteger(str);
    }

    public boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        s = s + '|';
        //跳过首部空格
        while (s.charAt(index) == ' ')
            index++;
        boolean numeric = scanInteger(s);//是否包含整数部分
        //跳过'.' 判断'.'的左右两边是否合法
        if (s.charAt(index) == '.') {
            index++;
            //有小数点，处理小数部分
            //小数点两边只要有一边有数字就可以，所以用||，
            //小数点右边不能有符号，所以用scanUnsignedInteger()  注意scanUnsignedInteger要在前面，否则不会进
            numeric = scanUnsignedInteger(s) || numeric;
        }
        if (s.charAt(index) == 'E' || s.charAt(index) == 'e') {
            index++;
            //指数部分  e的右边可以有符号 所有用scanInteger()
            //e或E的两边都要有数字，所以用&&
            numeric = numeric && scanInteger(s);
        }
        while (s.charAt(index) == ' ')
            index++;
        return numeric && s.charAt(index) == '|';
    }
}
