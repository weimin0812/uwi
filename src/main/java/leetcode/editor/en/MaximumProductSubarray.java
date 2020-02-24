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
            // todo use your fucking brain
            // 需要记录两个值，一个最大值，一个最小值，当nums[i] < 0时候最大最小值互换
            // max product
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int preMax = 1, preMin = 1, ret = nums[0];
            for (int num : nums) {
                if (num < 0) {
                    int t = preMax;
                    preMax = preMin;
                    preMin = t;
                }
                preMax = Math.max(num, num * preMax);
                preMin = Math.min(num, num * preMin);
                ret = Math.max(ret, preMax);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
