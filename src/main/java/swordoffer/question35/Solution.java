package swordoffer.question35;

public class Solution {
    // 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
    // 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
    // 即输出P%1000000007
    public int InversePairs(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return mergeSort(array, 0, array.length - 1);
    }

    private int mergeSort(int[] array, int l, int h) {
        if (l < h) {
            int m = l + (h - l) / 2;
            int leftCount = mergeSort(array, l, m);
            int rightCount = mergeSort(array, m + 1, h);
            int count = merge(array, l, m, h);
            return (leftCount + rightCount + count) % 1000000007;
        }
        return 0;
    }

    private int merge(int[] array, int l, int m, int h) {
        int[] t = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            t[i] = array[i];
        }
        int index = l, leftIndex = l, rightIndex = m + 1, count = 0;
        while (leftIndex <= m && rightIndex <= h) {
            if (t[leftIndex] <= t[rightIndex]) {
                array[index++] = t[leftIndex++];
            } else {
                // why (m-leftindex+1) not (rightIndex-m)
                count += (m - leftIndex + 1);
                array[index++] = t[rightIndex++];
            }
        }
        while (leftIndex <= m) {
            array[index++] = t[leftIndex++];
        }
        while (rightIndex <= h) {
            array[index++] = t[rightIndex++];
        }
        return count;
    }
}
