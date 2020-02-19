//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it is able to trap after raining. 
//
// 
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In 
//this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos
// for contributing this image! 
//
// Example: 
//
// 
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6 
// Related Topics Array Two Pointers Stack

package leetcode.editor.en;

public class TrappingRainWater {

    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            if (height == null || height.length <= 1) {
                return 0;
            }
            int l = 0, h = height.length - 1;
            int lMax = height[l], rMax = height[h];
            int ret = 0;
            while (l <= h) {
                lMax = Math.max(lMax, height[l]);
                rMax = Math.max(rMax, height[h]);
                if (lMax < rMax) {
                    ret += (lMax - height[l]);
                    l++;
                } else {
                    ret += (rMax - height[h]);
                    h--;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
