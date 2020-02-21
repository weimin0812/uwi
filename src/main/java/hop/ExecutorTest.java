package hop;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.tryLock(1, TimeUnit.MILLISECONDS);
        reentrantLock.unlock();
        // 重入
        // 公平锁、不公平锁
        // 显示unlock
        // 支持超时
        // 支持调用 Condition
        Condition condition = reentrantLock.newCondition();
        condition.wait();
        condition.signal();
        Callable<String> callable = () -> "1";

        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.await();
        countDownLatch.countDown();
        Thread thread = new Thread(() -> {
        });
        thread.join();

        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);
        ArrayBlockingQueue<Integer> integers = new ArrayBlockingQueue<>(10);
        blockingQueue.offer(1);
        blockingQueue.offer(1, 10, TimeUnit.MILLISECONDS);
        blockingQueue.take();
        blockingQueue.poll(10, TimeUnit.MILLISECONDS);

        BlockingQueue<Integer> arrayBlocking = new ArrayBlockingQueue<>(10);
        arrayBlocking.take();
        arrayBlocking.offer(1);
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
        Future<String> submit = executor.submit(callable);
        submit.get();
        new Thread(() -> {
        }).join();
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndAdd(1);
        atomicInteger.incrementAndGet();
    }

    //  ReentrantLock
    //  BlockingQueue是怎么实现的
    //  Callable是怎么实现的
    //  线程间怎么通信的
    //  wait notify notifyall
    //  Thread.join
    //  Thread.yield();
}
