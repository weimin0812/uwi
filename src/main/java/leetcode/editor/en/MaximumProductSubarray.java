//Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product. 
//
// Example 1: 
//
// 
//Input: [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray. 
// Related Topics Array Dynamic Programming
package leetcode.editor.en;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        int[] nums = {-2, 0, -1};
        solution.maxProduct(nums);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int max = 1, min = 1, ret = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    int t = max;
                    max = min;
                    min = t;
                }
                max = Math.max(max * nums[i], nums[i]);
                min = Math.min(min * nums[i], nums[i]);
                ret = Math.max(ret, max);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
