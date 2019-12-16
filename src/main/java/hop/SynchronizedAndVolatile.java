package hop;

public class SynchronizedAndVolatile {
    private int i = 0;
    public synchronized int sMethod() {
        i = i + 2;
        return i;
    }
    public int method() {
        synchronized (this) {
            i = i + 2;
            return i;
        }
    }
}
