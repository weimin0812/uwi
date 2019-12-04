package swordoffer.question47ToTest;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Sum_Solution(9));
    }

    public int Sum_Solution(int n) {
        boolean finish = n == 0 || (n = n + Sum_Solution(n - 1)) > 0;
        return n;
    }
}
