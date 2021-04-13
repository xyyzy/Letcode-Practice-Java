package 面试.去哪儿网;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class C {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        System.out.println(split.toString());
        //取出时间
        ArrayList<String> times = new ArrayList<>();
        //取出价格
        ArrayList<Integer> value = new ArrayList<>();
        //时间和价格一一对应
        HashMap<String, Integer> map = new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (String s1 : split) {
            String[] split1 = s1.split(":");
            value.add(Integer.valueOf(split1[1]));
            times.add(split1[0]);
            map.put(split1[0], Integer.valueOf(split1[1]));
        }

        //再对时间进行区分
        ArrayList<String[]> time = new ArrayList<>();
        for (String t : times) {
            String[] split1 = t.split("~");
            time.add(split1);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        ArrayList<ArrayList<Date>> dates = new ArrayList<>();
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //划分日期
                String[] split1 = o1.getKey().split("~");
                String[] split2 = o2.getKey().split("~");
                ArrayList<Date> dates1 = new ArrayList<>();
                ArrayList<Date> dates2 = new ArrayList<>();
                try {
                    dates1.add(format.parse(split1[0]));
                    dates1.add(format.parse(split1[1]));
                    dates.add(dates1);
                    dates2.add(format.parse(split1[0]));
                    dates2.add(format.parse(split1[1]));
                    dates.add(dates2);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            };
        });
    }
}

