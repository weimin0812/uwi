//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Find the minimum element. 
//
// The array may contain duplicates. 
//
// Example 1: 
//
// 
//Input: [1,3,5]
//Output: 1 
//
// Example 2: 
//
// 
//Input: [2,2,2,0,1]
//Output: 0 
//
// Note: 
//
// 
// This is a follow up problem to Find Minimum in Rotated Sorted Array. 
// Would allow duplicates affect the run-time complexity? How and why? 
// 
// Related Topics Array Binary Search
package leetcode.editor.en;

public class FindMinimumInRotatedSortedArrayIi {

    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArrayIi().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int l = 0, h = nums.length - 1;
            while (l < h) {
                int m = l + (h - l) / 2;
                if (nums[m] < nums[h]) {
                    h = m;
                } else if (nums[m] == nums[h]) {
                    h--;
                } else {
                    l = m + 1;
                }
            }
            return nums[l];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
