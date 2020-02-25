//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night. 
//
// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police. 
//
// Example 1: 
//
// 
//Input: [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
//             because they are adjacent houses.
// 
//
// Example 2: 
//
// 
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4. 
// Related Topics Dynamic Programming
package leetcode.editor.en;

import java.util.Arrays;

public class HouseRobberIi {

    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(notLoop(Arrays.copyOfRange(nums, 0, nums.length - 1)), notLoop(Arrays.copyOfRange(nums, 1, nums.length)));
        }

        private int notLoop(int[] a) {
            if (a == null || a.length == 0) {
                return 0;
            }
            int[] dp = new int[a.length + 2];
            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + a[i - 2]);
            }
            return dp[dp.length - 1];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
