//Given an integer array nums, find the contiguous subarray within an array (con
//taining at least one number) which has the largest product. 
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
        int[] nums = {2, 3, -2, 4};
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int preMax = 1, preMin = 1, ret = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    int t = preMax;
                    preMax = preMin;
                    preMin = t;
                }
                preMax = Math.max(preMax * nums[i], nums[i]);
                preMin = Math.min(preMin * nums[i], nums[i]);
                ret = Math.max(ret, preMax);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
