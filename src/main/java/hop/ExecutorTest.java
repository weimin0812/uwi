package hop;

import java.util.concurrent.*;

public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        executor.execute(() -> System.out.println("Hello"));
        executor.submit(() -> System.out.printf("Hello"));
    }

    //  ReentrantLock
    // BlockingQueue
}
