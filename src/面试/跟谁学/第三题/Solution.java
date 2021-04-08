package 面试.跟谁学.第三题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {


    static List<List<String>> mergeAccount(List<List<String>> accounts) {
        HashMap<Integer, String> names = new HashMap<>();
        HashMap<String, Integer> emails = new HashMap<>();
        int num = -1;

        for (List<String> account : accounts) {
            //获取名字
            String name = account.get(0);
            //账户长度
            int size = account.size();

            int id =-1;
            for (int i = 1; i <size ; i++) {
                //邮箱
                String email = account.get(i);
                if (emails.containsKey(email)){
                    id = emails.get(email);
                    break;
                }
            }
            if (id==-1) id=++num;
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                emails.put(email,id);
            }
            names.put(id,name);

        }
        List<List<String>> res =  new ArrayList<>();
        names.forEach((i,s)->{
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            res.add(list);
        });

        emails.forEach((s,i)->{
            res.get(i).add(s);
        });
        return res;
    }


}
