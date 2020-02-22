//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// If the target is not found in the array, return [-1, -1]. 
//
// Example 1: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4] 
//
// Example 2: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1] 
// Related Topics Array Binary Search

package leetcode.editor.en;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            return new int[]{search(nums, target, true), search(nums, target, false)};
        }

        private int search(int[] nums, int target, boolean first) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int l = 0, h = nums.length - 1;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if (nums[m] == target) {
                    if (first) {
                        if (m == 0 || nums[m] != nums[m - 1]) {
                            return m;
                        } else {
                            h--;
                        }
                    } else {
                        if (m == nums.length - 1 || nums[m] != nums[m + 1]) {
                            return m;
                        } else {
                            l++;
                        }
                    }
                } else if (nums[m] < target) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
