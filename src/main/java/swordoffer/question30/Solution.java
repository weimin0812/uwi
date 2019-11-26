package swordoffer.question30;

public class Solution {
    // 例如:{6,-3,-2,7,-15,1,2,2}给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0], sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (sum <= 0) {
                sum = 0;
            }
            sum += array[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
