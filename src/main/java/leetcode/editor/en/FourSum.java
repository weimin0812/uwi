//Given an array nums of n integers and an integer target, are there elements a,
// b, c, and d in nums such that a + b + c + d = target? Find all unique quadruple
//ts in the array which gives the sum of target. 
//
// Note: 
//
// The solution set must not contain duplicate quadruplets. 
//
// Example: 
//
// 
//Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics Array Hash Table Two Pointers

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ret = new ArrayList<>();
            if (nums == null || nums.length < 4) {
                return ret;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (j != i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int l = j + 1, h = nums.length - 1;
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
//leetcode submit region end(Prohibit modification and deletion)

}
