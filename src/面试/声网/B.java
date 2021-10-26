package 面试.声网;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>(str.length());
        for (char c : str.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}
