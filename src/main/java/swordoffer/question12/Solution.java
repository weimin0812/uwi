package swordoffer.question12;

public class Solution {
    // 给定一个double类型的浮点数base和int类型的整数exponent。
    // 求base的exponent次方。
    // 保证base和exponent不同时为0
    public double Power(double base, int exponent) {
        boolean negative = exponent < 0;
        exponent = Math.abs(exponent);
        double ret = 1.0;
        while (exponent != 0) {
            if (exponent % 2 == 1) {
                ret = ret * base;
            }
            exponent /= 2;
            base = base * base;
        }
        return negative ? 1 / ret : ret;
    }
}
