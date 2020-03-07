//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Note: 
//
// The solution set must not contain duplicate triplets. 
//
// Example: 
//
// 
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// Related Topics Array Two Pointers

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return ret;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int l = i + 1, h = nums.length - 1;
                while (l < h) {
                    int sum = nums[i] + nums[l] + nums[h];
                    if (sum == 0) {
                        ret.add(Arrays.asList(nums[i], nums[l], nums[h]));
                        l++;
                        h--;
                        while (l < h && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (l < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (sum < 0) {
                        l++;
                    } else {
                        h--;
                    }
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
