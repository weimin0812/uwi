package leetcode.dp.easy.question0198;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 3, 100};
        Solution solution = new Solution();
        int rob = solution.rob(nums);
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 2];
        int ret = dp[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
