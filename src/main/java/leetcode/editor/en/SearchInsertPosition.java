//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. 
//
// You may assume no duplicates in the array. 
//
// Example 1: 
//
// 
//Input: [1,3,5,6], 5
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: [1,3,5,6], 2
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: [1,3,5,6], 7
//Output: 4
// 
//
// Example 4: 
//
// 
//Input: [1,3,5,6], 0
//Output: 0
// 
// Related Topics Array Binary Search
package leetcode.editor.en;

public class SearchInsertPosition {

    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int l = 0, h = nums.length - 1;
            // last l == h m = l = h
            // if nums[m] < target
            //
            while (l <= h) {
                int m = l + (h - l) / 2;
                if (nums[m] == target) {
                    return m;
                } else if (nums[m] < target) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
