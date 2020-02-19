//Given a collection of distinct integers, return all possible permutations. 
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics Backtracking

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return ret;
            }
            boolean[] visited = new boolean[nums.length];
            permute(nums, 0, ret, new ArrayList<Integer>(), visited);
            return ret;
        }

        private void permute(int[] nums, int index, List<List<Integer>> ret, ArrayList<Integer> list, boolean[] visited) {
            if (index == nums.length) {
                ret.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    list.add(nums[i]);
                    permute(nums, index + 1, ret, list, visited);
                    visited[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
