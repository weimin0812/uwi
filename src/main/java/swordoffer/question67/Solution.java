package swordoffer.question67;

public class Solution {
    //    题目描述
//    给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//    输入描述:
//    输入一个数n，意义见题面。（2 <= n <= 60）
//    输出描述:
//    输出答案。
//    示例1
//    输入
//    8
//    输出
//    18
    public int cutRope(int target) {
        // n = 2 then 1*1 = 1
        // n = 3 then 2*1 = 2
        // n = 4 then 2*2 = 4
        // n = 5 then 2*3 = 6
        // n = 6 then 3*3 = 9
        // n = 7 then 3*4 = 12
        // n = 8 then 2*3*3 = 18
        // cut(n) = max(2*cut(n-2))
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int num3 = target / 3;
        if (target % 3 == 0) {
            return (int) Math.pow(3, num3);
        }
        if (target % 3 == 1) {
            return (int) (4 * Math.pow(3, num3 - 1));
        }
        if (target % 3 == 2) {
            return (int) (2 * Math.pow(3, num3));
        }
        return 0;
    }
}
