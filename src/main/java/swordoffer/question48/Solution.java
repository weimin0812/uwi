package swordoffer.question48;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sum(78, 100));
    }

    public int sum(int num1, int num2) {
        int carry = (num1 & num2) << 1;
        int sum = num1 ^ num2;
        while (carry != 0) {
            int t = sum;
            sum = sum ^ carry;
            carry = (carry & t) << 1;
        }
        return sum;
    }

}
