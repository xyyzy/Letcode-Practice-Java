package 哈希表._136_只出现一次的数字;

import java.util.HashMap;

public class Solution {
    /*
    * 哈希表做法
    * */
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (Integer num: nums
        ) {
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        for (Integer i: hashMap.keySet()
        ) {
            Integer ans = hashMap.get(i);
            if (ans==1)
                return i;
        }
        return -1;
    }

    /*
    * 异或
    * 一个数和 0 做 XOR 运算等于本身：a⊕0 = a
        一个数和其本身做 XOR 运算等于 0：a⊕a = 0
        XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
        故而在以上的基础条件上，将所有数字按照顺序做抑或运算，最后剩下的结果即为唯一的数字
    * */
    public static int singleNumber1(int[] nums) {
        int ans=0;
        for (int n: nums
             ) {
            ans ^=n;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,1,3,2,};
        int ans = singleNumber1(num);
        int a =3;
        int b=2;
        int c= a^b;
        int d = c^b;
        System.out.println(ans);
    }
}
