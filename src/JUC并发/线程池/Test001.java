package JUC并发.线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test001 {
    public static void main(String[] args) {
        //创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
                2,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3));
        for (int i = 1; i <= 6; i++) {
            TaskThred t1 = new TaskThred("任务" + i);
            //executor.execute(t1);是执行线程方法
            executor.execute(t1);
        }
        //executor.shutdown()不再接受新的任务，并且等待之前提交的任务都执行完再关闭，阻塞队列中的任务不会再执行。
        executor.shutdown();
    }
}

class TaskThred implements Runnable {
    private String taskName;

    public TaskThred(String taskName) {
        this.taskName = taskName;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + taskName);
    }
}

