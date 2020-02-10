//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elemen
//ts appear twice and others appear once. 
//
// Find all the elements of [1, n] inclusive that do not appear in this array. 
//
// Could you do it without extra space and in O(n) runtime? You may assume the r
//eturned list does not count as extra space. 
//
// Example:
// 
//Input:
//[4,3,2,7,8,2,3,1]
//
//Output:
//[5,6]
// 
// Related Topics Array

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int index = nums[i];
                if (index <= 0) {
                    index += nums.length;
                }
                if (nums[index - 1] > 0) {
                    nums[index - 1] = nums[index - 1] - nums.length;
                }
            }
            List<Integer> ret = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    ret.add(i + 1);
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
