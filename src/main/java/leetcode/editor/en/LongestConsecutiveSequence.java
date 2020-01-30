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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length < 1) {
                return 0;
            }
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int max = 0;
            for (Integer n : set) {
                if (!set.contains(n - 1)) {
                    int currentNum = n;
                    int currentCount = 1;
                    while (set.contains(currentNum + 1)) {
                        currentCount++;
                        currentNum++;
                    }
                    max = Math.max(max, currentCount);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
