//Implement next permutation, which rearranges numbers into the lexicographicall
//y next greater permutation of numbers. 
//
// If such arrangement is not possible, it must rearrange it as the lowest possi
//ble order (ie, sorted in ascending order). 
//
// The replacement must be in-place and use only constant extra memory. 
//
// Here are some examples. Inputs are in the left-hand column and its correspond
//ing outputs are in the right-hand column. 
//
// 1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics Array

package leetcode.editor.en;

public class NextPermutation {

    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length < 2) {
                return;
            }
            int i = nums.length - 2;
            for (; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    break;
                }
            }
            if (i >= 0) {
                int j = nums.length - 1;
                for (; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
            reverse(nums, i + 1, nums.length - 1);
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }

        private void reverse(int[] nums, int l, int h) {
            while (l < h) {
                swap(nums, l, h);
                l++;
                h--;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
