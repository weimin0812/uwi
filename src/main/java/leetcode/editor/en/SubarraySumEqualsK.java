//Given an array of integers and an integer k, you need to find the total number
// of continuous subarrays whose sum equals to k. 
//
// Example 1: 
// 
//Input:nums = [1,1,1], k = 2
//Output: 2
// 
// 
//
// Note: 
// 
// The length of the array is in range [1, 20,000]. 
// The range of numbers in the array is [-1000, 1000] and the range of the integ
//er k is [-1e7, 1e7]. 
// 
// 
// Related Topics Array Hash Table

package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int ret = 0, sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k)) {
                    ret += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
