package swordoffer.question48ToTest;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sum(78, 100));
    }
    public int sum(int a, int b) {
        int carry = (a & b) << 1;
        int sum = a ^ b;
        while (carry != 0) {
            int t = sum;
            sum = sum ^ carry;
            carry = (carry & t) << 1;
        }
        return sum;
    }

}
