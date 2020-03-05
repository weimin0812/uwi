//Given an integer array, you need to find one continuous subarray that if you o
//nly sort this subarray in ascending order, then the whole array will be sorted i
//n ascending order, too. 
//
// You need to find the shortest such subarray and output its length. 
//
// Example 1: 
// 
//Input: [2, 6, 4, 8, 10, 9, 15]
//Output: 5
//Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the 
//whole array sorted in ascending order.
// 
// 
//
// Note: 
// 
// Then length of the input array is in range [1, 10,000]. 
// The input array may contain duplicates, so ascending order here means <=. 
// 
// Related Topics Array

package leetcode.editor.en;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] a = Arrays.copyOf(nums, nums.length);
            Arrays.sort(a);
            int start = 0;
            while (start < a.length && a[start] == nums[start]) {
                start++;
            }
            int end = a.length - 1;
            while (start <= end && a[end] == nums[end]) {
                end--;
            }
            return end - start + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
