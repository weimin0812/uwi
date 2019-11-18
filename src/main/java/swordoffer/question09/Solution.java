package swordoffer.question09;

public class Solution {
    // 题目描述
    // 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
    // 求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public int JumpFloorII(int target) {
        // 1 1
        // 2 2
        // f(n) = f(n-1) + f(n-2) + .... + f(2) + f(1)
        // f(n-1) = f(n-2) + f(n-3) + .... + f(2) + f(1)
        // f(n) = 2*f(n-1)
        return 1 << (target - 1);
    }
}
