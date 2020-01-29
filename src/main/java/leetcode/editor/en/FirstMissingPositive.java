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

import java.util.Arrays;

public class FirstMissingPositive {

    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        int[] nums = {3, 4, -1, 1};
        int i = solution.firstMissingPositive(nums);
        System.out.println(i);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int i = 0;
            while (i < nums.length) {
                int num = nums[i];
                if (num <= 0 || num > nums.length) {
                    i++;
                } else if (nums[num - 1] != num) {
                    swap(nums, i, num - 1);
                } else {
                    i++;
                }
            }
            i = 0;
            while (i < nums.length && nums[i] == i + 1) {
                i++;
            }
            return i + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
