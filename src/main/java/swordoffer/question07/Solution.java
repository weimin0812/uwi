package swordoffer.question07;

public class Solution {
    // fibonacci
    // 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
    // n<=39
    public int Fibonacci(int n) {
        //0 0
        //1 1
        if (n < 2) {
            return n;
        }

        int f = 0, g = 1;
        for (int i = 2; i <= n; i++) {
            int t = f + g;
            f = g;
            g = t;
        }
        return g;
    }
}
