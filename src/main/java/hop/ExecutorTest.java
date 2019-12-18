package hop;

import java.util.concurrent.*;

public class ExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.offer(1);
        blockingQueue.offer(1, 10, TimeUnit.MILLISECONDS);
        blockingQueue.take();
        blockingQueue.poll(10, TimeUnit.MILLISECONDS);

        BlockingQueue<Integer> arrayBlocking = new ArrayBlockingQueue<>(10);
        arrayBlocking.take();
        arrayBlocking.offer(1);

        ExecutorService executor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        executor.execute(() -> System.out.println("Hello"));
        executor.submit(() -> System.out.printf("Hello"));
    }

    //  ReentrantLock
    //  BlockingQueue是怎么实现的
    //  Callable是怎么实现的

}
