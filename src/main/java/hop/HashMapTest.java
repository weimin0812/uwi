package hop;

import com.google.common.util.concurrent.AtomicDouble;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapTest {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    // hashmap
    // 多线程hash碰撞的时候会丢
    // 多线程扩容的时候会丢
    // ConcurrentHashMap
    // table是volatile的
    // synchronized + cas
    public static void main(String[] args) throws InterruptedException {
        int tab = tableSizeFor(1);

        HashMap<Long, String> map = new HashMap<>();
        Integer i = 8;
        i.equals(2);
        map.put(1L, "1L");
        map.put(789L, "789L");
        String s = map.get(1L);
        String s1 = map.get(789L);
        map.containsValue(null);

        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(1, 1);
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, 1);
        concurrentHashMap.get(1);
        concurrentHashMap.containsKey(1);
        concurrentHashMap.containsValue(null);
        concurrentHashMap.contains(1);
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndIncrement();
        atomicInteger.addAndGet(1);
        atomicInteger.getAndAdd(1);
    }

    public int getAndAddInt(int v, int inc) {
        int a;
        do {
            a = getV(v);
        } while (!compareAndSwap(v, a, a + inc));
        return a;
    }

    private boolean compareAndSwap(int v, int a, int b) {
        return true;
    }

    private int getV(int v) {
        return v;
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
