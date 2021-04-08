package 面试.携程2;



import java.util.*;

public class Soultion1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] packages;
        int[] price = new int[n];
        String b = sc.nextLine();
        String s = sc.nextLine();
        packages = s.split(" ");
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        //用户覆盖的权益
        String s2 = sc.nextLine();
        String s1 = sc.nextLine();
        String[] values = s1.split(" ");
        Arrays.sort(values);
        int[] value = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            value[i] = Integer.parseInt(values[i]);
        }


        HashMap<Integer, String> temp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            temp.put(price[i], packages[i]);
        }
        Arrays.sort(price);
        //排序之后价格和组合一一对应
        HashMap<Integer, String> PriceToPack = new HashMap<>();
        for (int i = 0; i < n; i++) {
            PriceToPack.put(price[i], temp.get(price[i]));
        }

        ArrayList<String> newPack = new ArrayList<>(PriceToPack.values());
        ArrayList<Integer> newValue = new ArrayList<>(PriceToPack.keySet());
        //组合和价格对应
        HashMap<String, Integer> PackToPrice = new HashMap<>();
        for (int i = 0; i < newPack.size(); i++) {
            PackToPrice.put(newPack.get(i), newValue.get(i));

        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < newPack.size() - 1; i++) {
            for (int j = i + 1; j < newPack.size(); j++) {
                //选中组合
                String flag = newPack.get(i) + "," + newPack.get(j);
                String[] all = flag.split(",");
                boolean have = isHave(all, values);
                //如果包含需求
                if (have) {
                    int sum = newValue.get(i) + newValue.get(j);
                    min = Math.min(sum, min);
                }
            }

        }
        System.out.println(min);

    }

    private static boolean isHave(String[] all, String[] values) {
        HashSet<String> set = new HashSet<String>();
        String temp = "";
        String flag = "";
        for (String value : values) {
            flag+=(value);
        }
        for (String value : all) {
            if (set.add(value)) {
                temp+=value;
            }
        }
        char[] charArray = temp.toCharArray();
        char[] charArray1 = flag.toCharArray();
        Arrays.sort(charArray);
        Arrays.sort(charArray1);
        String temp1 = "";
        String flag1="";
        for (char c : charArray) {
            temp1+=c;
        }
        for (char c : charArray1) {
            flag1+=c;
        }
        return temp1.equals(flag1);

    }
}
