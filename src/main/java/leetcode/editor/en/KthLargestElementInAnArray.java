//Find the kth largest element in an unsorted array. Note that it is the kth lar
//gest element in the sorted order, not the kth distinct element. 
//
// Example 1: 
//
// 
//Input: [3,2,1,5,6,4] and k = 2
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: [3,2,3,1,2,4,5,5,6] and k = 4
//Output: 4 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ array's length. 
// Related Topics Divide and Conquer Heap

package leetcode.editor.en;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
            for (int i = 0; i < nums.length; i++) {
                minHeap.offer(nums[i]);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
            return minHeap.peek();
        }

//        public int findKthLargest(int[] nums, int k) {
//            int targetIndex = nums.length - k;
//            int index = partition(nums, 0, nums.length - 1);
//            while (index != targetIndex) {
//                if (index < targetIndex) {
//                    index = partition(nums, index + 1, nums.length - 1);
//                } else {
//                    index = partition(nums, 0, index - 1);
//                }
//            }
//            return nums[targetIndex];
//        }

        private int partition(int[] nums, int l, int h) {
            int pivot = nums[l];
            while (l < h) {
                while (l < h && nums[h] >= pivot) {
                    h--;
                }
                nums[l] = nums[h];
                while (l < h && nums[l] <= pivot) {
                    l++;
                }
                nums[h] = nums[l];
            }
            nums[l] = pivot;
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
