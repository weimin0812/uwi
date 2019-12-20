package hop;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        ArrayBlockingQueue<Integer> integers = new ArrayBlockingQueue<>(10);
        blockingQueue.offer(1);
        blockingQueue.offer(1, 10, TimeUnit.MILLISECONDS);
        blockingQueue.take();
        blockingQueue.poll(10, TimeUnit.MILLISECONDS);

        BlockingQueue<Integer> arrayBlocking = new ArrayBlockingQueue<>(10);
        arrayBlocking.take();
        arrayBlocking.put(1);
        SynchronousQueue<Integer> syn = new SynchronousQueue<>();
        syn.take();
        syn.put(1);
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();
        priorityBlockingQueue.take();
        priorityBlockingQueue.put(1);
        ExecutorService executor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        executor.execute(() -> System.out.println("Hello"));
        executor.submit(() -> System.out.printf("Hello"));
    }

    //  ReentrantLock
    //  BlockingQueue是怎么实现的
    //  Callable是怎么实现的
    // 线程间怎么通信的

}
