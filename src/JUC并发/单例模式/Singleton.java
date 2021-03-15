package JUC并发.单例模式;

public class Singleton {
    //volatile 防止指令重排 和可见性
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public Singleton getUniqueInstance() {
        //先判断对象是否已经实例化过，没有实例化才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                //避免 singleTon== null时，第一个线程实例化后，进入阻塞状态的线程被唤醒后仍会进行实例化。
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
