//Given a set of distinct integers, nums, return all possible subsets (the power set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics Array Backtracking Bit Manipulation
package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return ret;
            }
            subsets(nums, ret, new ArrayList<Integer>(), 0);
            return ret;
        }

        private void subsets(int[] nums, List<List<Integer>> ret, ArrayList<Integer> list, int start) {
            ret.add(new ArrayList<>(list));
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                subsets(nums, ret, list, i + 1);
                list.remove(list.size() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
