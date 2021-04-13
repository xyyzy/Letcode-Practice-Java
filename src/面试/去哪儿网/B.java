package 面试.去哪儿网;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class B {
    //在某个对数字进行加密的系统，对于x位的数字，会对中间的[start, end)位改为大小写敏感的字母后存储，start最小为0，
    // 从左边开始数。
    //
    //比如11位的电话号码，会对第[3, 7)进行加密，12312340000加密为123AbCd0000，
    // 结果一次操作操作失误把号码的所有字母都转换成了小写，比如123AbCd0000
    // 变成了123abcd0000。给出x, start, end和一个操作失误后的号码，
    // 求所有可能的操作失误前的号码（以字符序排序后输出，123ABCD0000应为第一个，
    // 123abcd0000为最后一个，最后一个输出之后不要加换行符)。


    static List<String> getAll(int length, int start, int end, String input) {
        //在一个区间内做全排列
        ArrayList<String> res = new ArrayList<>();
        String prev = input.substring(0, start);
        String after = input.substring(end, length);
        //对中间一部分进行全排列
        char[] charArray = input.toCharArray();
        helper(res, end - start, start, end, charArray, start);
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return res;
    }

    private static void helper(ArrayList<String> res, int length, int start, int end, char[] arr, int index) {
        if (index == end) {
            res.add(new String(arr));
            return;
        }

        helper(res, length, start, end, arr, index + 1);
        //字符的话做变换
        if (Character.isLetter(arr[index])) {
            if (arr[index]<'z'&&arr[index]>'a'){
                arr[index] = (char) (arr[index] -('a'-'A'));
            }
//            arr[index] ^= 1 << 5;
            if (arr[index]<'Z'&&arr[index]>'A'){
                arr[index] = (char) (arr[index] +('a'-'A'));
            }
            helper(res, length, start, end, arr, index + 1);
        }

    }
}
