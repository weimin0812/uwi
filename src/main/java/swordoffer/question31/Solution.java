package swordoffer.question31;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.NumberOf1Between1AndN_Solution(1));
    }

    // 从1到n中1出现的次数。
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        int digit = 1;
        while (digit <= n) {
            int middle = (n / digit) % 10;
            int after = n % digit;
            int before = n / (digit * 10);
            // todo remember
            if (middle == 0) {
                count += before * digit;
            } else if (middle == 1) {
                count += before * digit + after + 1;
            } else {
                count += (before + 1) * digit;
            }
            digit *= 10;
        }
        return count;
    }
}
