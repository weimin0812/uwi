package hop;

import sun.misc.Unsafe;

public class MyAtomicInteger {
    // aba问题
    // cas aba问题
    // 公众号小灰有个例子：
    // 100 50
    // thread 1 100--->50
    // thread 2 100--->50
    // thread 3 50---->100
    private volatile int value;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset((MyAtomicInteger.class.getDeclaredField("value")));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public final int getAndSet(int newValue) {
        return unsafe.getAndSetInt(this, valueOffset, newValue);
    }

    public final int getAndAdd() {
        return unsafe.getAndAddInt(this, valueOffset, 1);
    }
}

class MyUnsafe {
    public final int getAndAddInt(Object object, long offset, int inc) {
        int a;
        do {
            a = getIntVolatile(object, offset);
        } while (!compareAndSwapInt(object, offset, a, a + inc));
        return a;
    }

    private boolean compareAndSwapInt(Object object, long offset, int a, int b) {
        return true;
    }

    private int getIntVolatile(Object object, long offset) {
        return 0;
    }
}

