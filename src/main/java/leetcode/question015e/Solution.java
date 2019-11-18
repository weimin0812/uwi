package leetcode.question015e;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1, h = nums.length - 1, sum = -nums[i];
            while (l < h) {
                int t = nums[l] + nums[h];
                if (t == sum) {
                    ret.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    l++;
                    h--;
                    while (l < h && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < h && nums[h] == nums[h + 1]) {
                        h--;
                    }
                } else if (t < sum) {
                    l++;
                } else {
                    h--;
                }
            }
        }

        return ret;
    }
}
