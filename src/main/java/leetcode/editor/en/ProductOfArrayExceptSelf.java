//Given an array nums of n integers where n > 1, return an array output such tha
//t output[i] is equal to the product of all the elements of nums except nums[i]. 
//
//
// Example: 
//
// 
//Input:  [1,2,3,4]
//Output: [24,12,8,6]
// 
//
// Note: Please solve it without division and in O(n). 
//
// Follow up: 
//Could you solve it with constant space complexity? (The output array does not 
//count as extra space for the purpose of space complexity analysis.) 
// Related Topics Array

package leetcode.editor.en;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] ret = new int[nums.length];
            //left
            for (int i = 0; i < ret.length; i++) {
                ret[i] = i == 0 ? 1 : ret[i - 1] * nums[i - 1];
            }
            //right
            int r = 1;
            for (int i = ret.length - 2; i >= 0; i--) {
                r = r * nums[i + 1];
                ret[i] = ret[i] * r;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
