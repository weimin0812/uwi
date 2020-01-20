//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero. 
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

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ret = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
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
                    } else if (sum > 0) {
                        h--;
                    } else {
                        l++;
                    }
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
