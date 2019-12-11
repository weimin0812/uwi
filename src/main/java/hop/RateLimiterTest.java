package hop;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Date;

public class RateLimiterTest {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(1);
        for (int i = 1; i < 10; i = i + 2) {
            double waitTime = rateLimiter.acquire(i);
            System.out.println("cutTime=" + new Date() + " acq:" + i + " waitTime:" + waitTime);
        }
    }
}
