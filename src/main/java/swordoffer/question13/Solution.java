package swordoffer.question13;

import java.util.Arrays;

public class Solution {
    // 用例:[1,2,3,4,5,6,7]
    // 对应输出应该为:[1,3,5,7,2,4,6]
    // 你的输出       1 3 5 7 6 4 2
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        solution.reOrderArray(array);
        Arrays.stream(array).forEach(a -> System.out.print(a + " "));
    }

    // 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    // 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
    // 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public void reOrderArray(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int l, int h) {
        if (l >= h) {
            return;
        }
        int m = l + (h - l) / 2;
        mergeSort(array, l, m);
        mergeSort(array, m + 1, h);
        merge(array, l, m, h);
    }

    private void merge(int[] array, int l, int m, int h) {
        int[] t = new int[array.length];
        for (int i = l; i <= h; i++) {
            t[i] = array[i];
        }
        int index = l, leftIndex = l, rightIndex = m + 1;
        while (leftIndex <= m && rightIndex <= h) {
            // 为了保持排序的稳定性，当左侧的小于等于右侧的时候，用左侧的值
            // 即左侧的为奇数、或者左侧右侧同事为偶数
            if (t[leftIndex] % 2 == 1 || t[leftIndex] % 2 == 0 && t[rightIndex] % 2 == 0) {
                array[index++] = t[leftIndex++];
            } else {
                array[index++] = t[rightIndex++];
            }
        }
        while (leftIndex <= m) {
            array[index++] = t[leftIndex++];
        }
        while (rightIndex <= h) {
            array[index++] = t[rightIndex++];
        }
    }
}
