package leetcode.common;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedDemo {
    private int normalI = 10;

    private volatile int vi = 18;

    public void synchronizedThis() {
        synchronized (this) {
            System.out.println("synchronized this");
        }
    }

    public void synchronizedClass() {
        synchronized (SynchronizedDemo.class) {
            System.out.println("synchronized class");
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        String put = map.put("as", "as");
        System.out.println(put);
        put = map.put("as", "asd");
        map.isEmpty();
        map.containsKey("as");
        map.put("tets", null);
        map.entrySet();
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("aa", "aa");
        concurrentHashMap.get(null);
        System.out.println(map.containsKey("tets"));
        System.out.println(put);
        map.get("as");
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put(null, "as");
        hashtable.get(null);
        AtomicInteger ac = new AtomicInteger(0);
        ac.incrementAndGet();


    }
}
