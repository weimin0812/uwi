package swordoffer.question35;

public class Solution {
    // 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
    // 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
    // 即输出P%1000000007
    public int InversePairs(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int[] t = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            t[i] = array[i];
        }
        return mergeSort(array, t, 0, array.length - 1);
    }

    // todo only mod where count update

    private int mergeSort(int[] array, int[] t, int l, int h) {
        if (l < h) {
            int m = l + (h - l) / 2;
            int leftCount = mergeSort(array, t, l, m);
            int rightCount = mergeSort(array, t, m + 1, h);
            int count = merge(array, t, l, m, h);
            return (leftCount + rightCount + count) % 1000000007;
        }
        return 0;
    }

    private int merge(int[] array, int[] t, int l, int m, int h) {
        for (int i = l; i <= h; i++) {
            t[i] = array[i];
        }
        int count = 0, leftIndex = l, rightIndex = m + 1;
        for (int index = l; index <= h; index++) {
            if (leftIndex > m) {
                array[index] = t[rightIndex++];
            } else if (rightIndex > h) {
                array[index] = t[leftIndex++];
            } else if (t[leftIndex] <= t[rightIndex]) {
                array[index] = t[leftIndex++];
            } else {
                count += (m - leftIndex + 1);
                count = count % 1000000007;
                array[index] = t[rightIndex++];
            }
        }
        return count;
    }
}
