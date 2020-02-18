//Given a set of candidate numbers (candidates) (without duplicates) and a targe
//t number (target), find all unique combinations in candidates where the candidat
//e numbers sums to target. 
//
// The same repeated number may be chosen from candidates unlimited number of ti
//mes. 
//
// Note: 
//
// 
// All numbers (including target) will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8,
//A solution set is:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// 
// Related Topics Array Backtracking

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ret = new ArrayList<>();
            if (candidates == null || candidates.length < 1) {
                return ret;
            }
            combinationSum(candidates, target, ret, new ArrayList<Integer>(), 0, 0);
            return ret;
        }

        private void combinationSum(int[] candidates, int target, List<List<Integer>> ret, ArrayList<Integer> list, int start, int sum) {
            if (sum > target) {
                return;
            }
            if (sum == target) {
                ret.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                combinationSum(candidates, target, ret, list, i, sum + candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
