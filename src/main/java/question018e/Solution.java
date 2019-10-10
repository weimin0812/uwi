package question018e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null) {
            return ret;
        }
        int length = nums.length;
        if (length < 4) {
            return ret;
        }

        Arrays.sort(nums);
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int l = j + 1, h = length - 1;
                while (l < h) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[h];
                    if (sum == target) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[l], nums[h]));
                        l++;
                        h--;
                        while (l < h && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (l < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (sum < target) {
                        l++;
                    } else {
                        h--;
                    }
                }
            }
        }

        return ret;
    }
}
