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
            //当前点能够存储的水取决于左侧最高，和右侧最高
            if (height == null || height.length == 0) {
                return 0;
            }
            int l = 0, r = height.length - 1, lMax = height[l], rMax = height[r];
            int ret = 0;
            while (l <= r) {
                lMax = Math.max(lMax, height[l]);
                rMax = Math.max(rMax, height[r]);
                if (lMax <= rMax) {
                    ret += (lMax - height[l]);
                    l++;
                } else {
                    ret += (rMax - height[r]);
                    r--;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
