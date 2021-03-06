package leetcode.question004e;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int t = m;
            m = n;
            n = t;
        }

        int iLow = 0, iHigh = m, halfLen = (m + n + 1) / 2;
        while (iLow <= iHigh) {
            int i = iLow + (iHigh - iLow) / 2;
            int j = halfLen - i;
            if (i > 0 && nums1[i - 1] > nums2[j]) {
                iHigh = i - 1;
            } else if (i < m && nums2[j - 1] > nums1[i]) {
                iLow = i + 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0;
    }
}

