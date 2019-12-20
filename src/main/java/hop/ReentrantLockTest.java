package hop;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    lock.lock();
                    counter++;
                    lock.unlock();
                }
            }).start();
        }
        Thread.sleep(1000L);
        System.out.println(counter);
    }

}
