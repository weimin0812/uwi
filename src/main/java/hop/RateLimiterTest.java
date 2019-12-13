package hop;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterTest {
    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, 1);
        HashMap<Object, Object> map = new HashMap();
        map.put(1, 1);
        Hashtable hashtable = new Hashtable();
        hashtable.put(1, 1);
        RateLimiter rateLimiter = RateLimiter.create(10);
        for (int i = 1; i < 100; i++) {
            double waitTime = rateLimiter.acquire();
            System.out.println("cutTime=" + new Date().getTime() + " acq:" + i + " waitTime:" + waitTime);
        }
    }
}
