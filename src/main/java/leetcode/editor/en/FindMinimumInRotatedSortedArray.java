//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Find the minimum element. 
//
// You may assume no duplicate exists in the array. 
//
// Example 1: 
//
// 
//Input: [3,4,5,1,2] 
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: [4,5,6,7,0,1,2]
//Output: 0
// 
// Related Topics Array Binary Search
package leetcode.editor.en;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            // find minimum in rotated sorted array
            int l = 0, h = nums.length - 1;
            while (l < h) {
                int m = l + (h - l) / 2;
                if (nums[m] < nums[h]) {
                    h = m;
                } else {
                    l = m + 1;
                }
            }
            return nums[l];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
