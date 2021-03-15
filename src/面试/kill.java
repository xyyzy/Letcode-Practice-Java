package 面试;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.*;

/**
 * 并发写的有问题
 * 免单写了 未测试
 */
class MyThread implements Callable<String> {

    public class Order {
        private String id;
        private Long data;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Long getData() {
            return data;
        }

        public void setData(Long data) {
            this.data = data;
        }

        public Order(String id, Long data) {
            this.id = id;
            this.data = data;
        }
    }


    ArrayList<Order> list = new ArrayList<Order>();

    HashMap<Integer, Long> map = new HashMap<>();
    // 存放结果
    static HashMap<String, String> res = new HashMap<>();
    public volatile static int count = 100;


    @Override
    public String call() throws Exception {
        for (int i = count; i > 0; i--) {
//			Thread.yield();
            Thread.sleep(200);
            list.add(new Order(Thread.currentThread().getName(), System.currentTimeMillis()));
        }

        return "sale out";
    }

    //获取格式化时间
    public String getTime(Long date) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String format = simpleFormat.format(date);
        return format;
    }

    //将面单订单存入res中，最后遍历获取
    public HashMap<String, String> getOrder(ArrayList<Order> list) {
        for (int i = 1; i < list.size(); i++) {
            Long data = list.get(i - 1).getData();
            //秒
            long s = data / 1000 & 60;
            //毫秒
            long ms = data % 1000;
            //组合之后
            long on = 1000 * s + ms;
            map.put(i, on);
        }
        for (int i = 1; i < map.size(); i++) {
            int min = Integer.MAX_VALUE;
            //当同一秒情况下，比较毫秒，小的放入结果集
            if (map.get(i) / 1000 == map.get(i - 1) / 1000 && map.get(i) % 1000 < map.get(i - 1) % 1000) {
                res.put("订单" + i, getTime(list.get(i - 1).getData()));
            }
        }
        return res;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new MyThread();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread mThread = new Thread(futureTask, "1");
        Thread mThread2 = new Thread(futureTask, "2");
        Thread mThread3 = new Thread(futureTask, "3");
//		mThread.setName("hhh");
        mThread.start();
        mThread2.start();
        mThread3.start();
        for (String key : res.keySet()) {
            String value = res.get(key);
            System.out.println(key + "  " + value);
        }
    }

}
