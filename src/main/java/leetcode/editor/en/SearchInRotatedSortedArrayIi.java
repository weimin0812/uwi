//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. 
//
// (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]). 
//
// You are given a target value to search. If found in the array return true, otherwise return false. 
//
// Example 1: 
//
// 
//Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// 
//
// Example 2: 
//
// 
//Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false 
//
// Follow up: 
//
// 
// This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates. 
// Would this affect the run-time complexity? How and why? 
// 
// Related Topics Array Binary Search
package leetcode.editor.en;

public class SearchInRotatedSortedArrayIi {

    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean search(int[] nums, int target) {
            int l = 0, h = nums.length - 1;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if (nums[m] == target) {
                    return true;
                }
                if (nums[m] == nums[h] && nums[l] == nums[m]) {
                    l++;
                    h--;
                } else if (nums[m] <= nums[h]) {
                    if (nums[m] < target && target <= nums[h]) {
                        l = m + 1;
                    } else {
                        h = m - 1;
                    }
                } else {
                    if (nums[l] <= target && target < nums[m]) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
