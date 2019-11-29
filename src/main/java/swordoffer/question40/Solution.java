package swordoffer.question40;

public class Solution {
    // 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        //todo fuck shit stupid
        if (array == null || array.length < 2) {
            return;
        }
        int xor = 0;
        for (int i : array) {
            xor ^= i;
        }
        int count = 0;
        while ((xor & (1 << count)) == 0) {
            count++;
        }
        for (int i : array) {
            if ((i & (1 << count)) == 0) {
                num1[0] ^= i;
            } else {
                num2[0] ^= i;
            }
        }
    }
}
