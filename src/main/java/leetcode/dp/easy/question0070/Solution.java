package leetcode.dp.easy.question0070;

public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n should be > 0");
        }

        if (n <= 2) {
            return n;
        }
        int f = 1, g = 2;
        for (int i = 2; i < n; i++) {
            int t = g;
            g = f + g;
            f = t;
        }
        return g;
    }
}
