//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target. 
//
// Each number in candidates may only be used once in the combination. 
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
//Input: candidates = [10,1,2,7,6,1,5], target = 8,
//A solution set is:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5,
//A solution set is:
//[
//  [1,2,2],
//  [5]
//]
// 
// Related Topics Array Backtracking
package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi {

    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ret = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, ret, new ArrayList<Integer>(), 0, 0);
            return ret;
        }

        private void dfs(int[] candidates, int target, List<List<Integer>> ret, ArrayList<Integer> list, int start, int sum) {
            if (sum > target) {
                return;
            }
            if (sum == target) {
                ret.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                dfs(candidates, target, ret, list, i + 1, sum + candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
