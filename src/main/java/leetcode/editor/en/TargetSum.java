//
//You are given a list of non-negative integers, a1, a2, ..., an, and a target, 
//S. Now you have 2 symbols + and -. For each integer, you should choose one from 
//+ and - as its new symbol.
// 
//
// Find out how many ways to assign symbols to make sum of integers equal to tar
//get S. 
// 
//
// Example 1: 
// 
//Input: nums is [1, 1, 1, 1, 1], S is 3. 
//Output: 5
//Explanation: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//There are 5 ways to assign symbols to make the sum of nums be target 3.
// 
// 
//
// Note: 
// 
// The length of the given array is positive and will not exceed 20. 
// The sum of elements in the given array will not exceed 1000. 
// Your output answer is guaranteed to be fitted in a 32-bit integer. 
// 
// Related Topics Dynamic Programming Depth-first Search

package leetcode.editor.en;

public class TargetSum {

    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int count = 0;

        public int findTargetSumWays(int[] nums, int S) {
            count = 0;
            findTargetSumWays(nums, 0, 0, S);
            return count;
        }

        private void findTargetSumWays(int[] nums, int index, int sum, int target) {
            if (index == nums.length) {
                if (sum == target) {
                    count++;
                }
            } else {
                findTargetSumWays(nums, index + 1, sum + nums[index], target);
                findTargetSumWays(nums, index + 1, sum - nums[index], target);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
