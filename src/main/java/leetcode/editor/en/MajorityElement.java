//Given an array of size n, find the majority element. The majority element is t
//he element that appears more than ⌊ n/2 ⌋ times. 
//
// You may assume that the array is non-empty and the majority element always ex
//ist in the array. 
//
// Example 1: 
//
// 
//Input: [3,2,3]
//Output: 3 
//
// Example 2: 
//
// 
//Input: [2,2,1,1,1,2,2]
//Output: 2
// 
// Related Topics Array Divide and Conquer Bit Manipulation

package leetcode.editor.en;

public class MajorityElement {

    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int ret = nums[0], count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (ret == nums[i]) {
                    count++;
                } else {
                    count--;
                }
                if (count == 0) {
                    ret = nums[i];
                    count++;
                }
            }
            count = 0;
            for (int num : nums) {
                if (num == ret) {
                    count++;
                }
            }
            return count > nums.length / 2 ? ret : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
