//Given an unsorted array of integers, find the length of the longest consecutiv
//e elements sequence. 
//
// Your algorithm should run in O(n) complexity. 
//
// Example: 
//
// 
//Input: [100, 4, 200, 1, 3, 2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Theref
//ore its length is 4.
// 
// Related Topics Array Union Find

package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int ret = 0;
            for (int num : nums) {
                if (set.contains(num - 1)) {
                    continue;
                }
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    num++;
                }
                ret = Math.max(ret, count);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
