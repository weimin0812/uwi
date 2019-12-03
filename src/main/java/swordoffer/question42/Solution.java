package swordoffer.question42;

import java.util.ArrayList;

public class Solution {
    // 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        // a+b = s a-b=d  a = (s+d)/2  b = (s-d)/2
        // a*b = (s*s-d*d)/2 d larger a*b smaller
        ArrayList<Integer> ret = new ArrayList<>();
        if (array == null || array.length < 2) {
            return ret;
        }
        int l = 0, h = array.length - 1;
        while (l < h) {
            if (array[l] + array[h] == sum) {
                ret.add(array[l]);
                ret.add(array[h]);
                return ret;
            } else if (array[l] + array[h] < sum) {
                l++;
            } else {
                h--;
            }
        }
        return ret;
    }
}
