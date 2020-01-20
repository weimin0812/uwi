//Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water. 
//
// Note: You may not slant the container and n is at least 2. 
//
// 
//
// 
//
// The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49. 
//
// 
//
// Example: 
//
// 
//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49 Related Topics Array Two Pointers
package leetcode.editor.en;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int ret = 0, l = 0, r = height.length - 1;
            while (l <= r) {
                int h = Math.min(height[l], height[r]);
                ret = Math.max(ret, (r - l) * h);
                if (height[l] <= height[r]) {
                    l++;
                } else {
                    r--;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
