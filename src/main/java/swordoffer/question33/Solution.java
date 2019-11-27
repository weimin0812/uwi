package swordoffer.question33;

public class Solution {
    // 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
    // 例如6、8都是丑数，但14不是，因为它包含质因子7。
    // 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        int[] dp = new int[index];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < index; i++) {
            dp[i] = Math.min(Math.min(2 * dp[index2], 3 * dp[index3]), 5 * dp[index5]);
            if (dp[i] == 2 * dp[index2]) {
                index2++;
            }
            if (dp[i] == 3 * dp[index3]) {
                index3++;
            }
            if (dp[i] == 5 * dp[index5]) {
                index5++;
            }
        }
        return dp[index - 1];
    }
}
