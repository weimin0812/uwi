package swordoffer.question37;

public class Solution {
    // 统计一个数字在排序数组中出现的次数。
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return lastOf(array, k) - firstOf(array, k) + 1;
    }

    private int firstOf(int[] array, int k) {
        return binarySearch(array, k, true);
    }

    private int lastOf(int[] array, int k) {
        return binarySearch(array, k, false);
    }

    private int binarySearch(int[] array, int k, boolean first) {
        int l = 0, h = array.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (array[m] == k) {
                if (first) {
                    if (m == 0 || array[m - 1] != k) {
                        return m;
                    }
                    h = m - 1;
                } else {
                    if (m == array.length - 1 || array[m + 1] != k) {
                        return m;
                    }
                    l = m + 1;
                }

            } else if (array[m] < k) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return first ? -1 : -2;
    }

}
