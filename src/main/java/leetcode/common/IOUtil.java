package leetcode.common;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class IOUtil {
    public static void main(String[] args) {
        int corePoolSize = 10;
        int maximumPoolSize = 15;
        long keepAliveTime = 1000;
        TimeUnit second = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);
        Executor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, second, workQueue);
        executor.execute(() -> {
            System.out.println("My Runnable");
        });

        // cas是怎么实现的

        // blocking queue是怎么实现的

        // 带返回值的线程池是怎么实现的

    }
}


class User {
    private int age;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
