//Given a non-empty array containing only positive integers, find if the array c
//an be partitioned into two subsets such that the sum of elements in both subsets
// is equal. 
//
// Note: 
//
// 
// Each of the array element will not exceed 100. 
// The array size will not exceed 200. 
// 
//
// 
//
// Example 1: 
//
// 
//Input: [1, 5, 11, 5]
//
//Output: true
//
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// 
//
// Example 2: 
//
// 
//Input: [1, 2, 3, 5]
//
//Output: false
//
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Related Topics Dynamic Programming

package leetcode.editor.en;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 == 1) {
                return false;
            }
            int n = nums.length;
            sum = sum / 2;
            boolean[][] dp = new boolean[n + 1][sum + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (i == 0) {
                        dp[i][j] = j == 0;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                        if (j >= nums[i - 1]) {
                            dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                        }
                    }
                }
            }
            return dp[n][sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
