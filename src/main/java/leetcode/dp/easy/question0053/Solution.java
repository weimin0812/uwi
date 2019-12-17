package leetcode.dp.easy.question0053;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ret = nums[0];
        int sum = 0;
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
