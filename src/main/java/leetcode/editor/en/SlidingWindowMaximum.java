//Given an array nums, there is a sliding window of size k which is moving from 
//the very left of the array to the very right. You can only see the k numbers in 
//the window. Each time the sliding window moves right by one position. Return the
// max sliding window. 
//
// Example: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7] 
//Explanation: 
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty arr
//ay. 
//
// Follow up: 
//Could you solve it in linear time? Related Topics Heap Sliding Window

package leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        solution.maxSlidingWindow(nums, k);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // sliding window maximum
            if (nums == null || nums.length == 0) {
                return nums;
            }
            Deque<Integer> deque = new ArrayDeque<>();
            int[] ret = new int[nums.length - k + 1];
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                while (!deque.isEmpty() && num >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offer(i);
                while (!deque.isEmpty() && deque.peek() <= i - k) {
                    deque.pollFirst();
                }
                if (i >= k - 1) {
                    ret[index++] = nums[deque.peek()];
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
