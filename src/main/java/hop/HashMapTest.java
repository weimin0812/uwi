package hop;

import com.google.common.util.concurrent.AtomicDouble;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapTest {
    // hashmap
    // 多线程hash碰撞的时候会丢
    // 多线程扩容的时候会丢
    // ConcurrentHashMap
    // table是volatile的
    // synchronized + cas
    public static void main(String[] args) throws InterruptedException {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, null);
        boolean b = map.containsKey(1);
        map.get(1);
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(1, 1);
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, 1);
        concurrentHashMap.get(1);
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
}
