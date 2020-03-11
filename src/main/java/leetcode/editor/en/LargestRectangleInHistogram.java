//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram. 
//
// 
//
// 
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3]. 
//
// 
//
// 
//The largest rectangle is shown in the shaded area, which has area = 10 unit. 
//
// 
//
// Example: 
//
// 
//Input: [2,1,5,6,2,3]
//Output: 10
// 
// Related Topics Array Stack
package leetcode.editor.en;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int ret = 0;
            for (int i = 0; i < heights.length; i++) {
                int l = i, r = i;
                while (l >= 0 && heights[l] >= heights[i]) {
                    l--;
                }
                while (r < heights.length && heights[r] >= heights[i]) {
                    r++;
                }
                ret = Math.max(heights[i] * (r - l - 1), ret);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
