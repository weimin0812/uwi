//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// You are given a target value to search. If found in the array return its index, otherwise return -1. 
//
// You may assume no duplicate exists in the array. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// Example 1: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1 
// Related Topics Array Binary Search
package leetcode.editor.en;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int index = solution.search(nums, target);
        System.out.println(index);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0, h = nums.length - 1;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if (nums[m] == target) {
                    return m;
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
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
