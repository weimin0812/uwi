package leetcode.question016e;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, h = nums.length - 1;

            while (l < h) {
                int sum = nums[i] + nums[l] + nums[h];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    l++;
                } else {
                    h--;
                }

                ret = Math.abs(target - ret) > Math.abs(target - sum) ? sum : ret;
            }
        }
        return ret;
    }
}
