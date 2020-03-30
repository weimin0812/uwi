package hop.ipc;

public class WaitAndNotify {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("A try to get the lock");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                System.out.println("A got the lock");
                System.out.println("A wait");
                try {
                    lock.wait(1);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A go on");
            }
        }).start();

        new Thread(() -> {
            System.out.println("B try to get the lock");
            synchronized (lock) {
                System.out.println("B got the lock");
                System.out.println("B notify");
                boolean flag = true;
                lock.notify();
                lock.notifyAll();
                while (flag) {

                }
                System.out.println("B finish");

            }
        }).start();

    }

}
