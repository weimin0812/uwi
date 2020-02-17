//There are two sorted arrays nums1 and nums2 of size m and n respectively. 
//
// Find the median of the two sorted arrays. The overall run time complexity sho
//uld be O(log (m+n)). 
//
// You may assume nums1 and nums2 cannot be both empty. 
//
// Example 1: 
//
// 
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
// 
//
// Example 2: 
//
// 
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5
// 
// Related Topics Array Binary Search Divide and Conquer

package leetcode.editor.en;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                int[] t = nums1;
                nums1 = nums2;
                nums2 = t;
            }
            int l1 = nums1.length, l2 = nums2.length;
            int l = 0, h = l1, half = (l1 + l2 + 1) / 2;
            while (l <= h) {
                int i = l + (h - l) / 2;
                int j = half - i;
                if (i != 0 && nums1[i - 1] > nums2[j]) {
                    h = i - 1;
                } else if (i != l1 && nums2[j - 1] > nums1[i]) {
                    l = i + 1;
                } else {
                    int maxLeft = i == 0 ? nums2[j - 1] : j == 0 ? nums1[i - 1] : Math.max(nums1[i - 1], nums2[j - 1]);
                    if ((l1 + l2) % 2 == 1) {
                        return maxLeft;
                    }
                    int minRight = i == l1 ? nums2[j] : j == l2 ? nums1[i] : Math.min(nums1[i], nums2[j]);
                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
