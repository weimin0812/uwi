//Given an unsorted integer array, find the smallest missing positive integer. 
//
// Example 1: 
//
// 
//Input: [1,2,0]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: [3,4,-1,1]
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: [7,8,9,11,12]
//Output: 1
// 
//
// Note: 
//
// Your algorithm should run in O(n) time and uses constant extra space. 
// Related Topics Array

package leetcode.editor.en;

public class FirstMissingPositive {

    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 1;
            }
            for (int i = 0; i < nums.length; ) {
                int n = nums[i];
                if (n >= 1 && n <= nums.length) {
                    if (nums[n - 1] == n) {
                        i++;
                    } else {
                        int t = nums[n - 1];
                        nums[n - 1] = n;
                        nums[i] = t;
                    }
                } else {
                    i++;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
