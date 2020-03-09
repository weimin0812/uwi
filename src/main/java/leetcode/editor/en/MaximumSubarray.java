//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// Example: 
//
// 
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Follow up: 
//
// If you have figured out the O(n) solution, try coding another solution using 
//the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming

package leetcode.editor.en;

public class MaximumSubarray {

    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int ret = nums[0], sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (sum < 0) {
                    sum = 0;
                }
                sum += nums[i];
                ret = Math.max(sum, ret);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
