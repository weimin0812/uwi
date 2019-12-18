package hop;

import org.openjdk.jol.info.ClassLayout;

public class JOLTest {
    private static MyLock myLock = new MyLock();

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(myLock).toPrintable());
        new Thread(() -> {
            synchronized (myLock) {
                System.out.println(ClassLayout.parseInstance(myLock).toPrintable());
            }
        }).start();
    }
}

class MyLock {
    private int lock = 10;
}
