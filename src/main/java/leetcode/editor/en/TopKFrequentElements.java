//Given a non-empty array of integers, return the k most frequent elements. 
//
// Example 1: 
//
// 
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1] 
// 
//
// Note: 
//
// 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements. 
// Your algorithm's time complexity must be better than O(n log n), where n is t
//he array's size. 
// 
// Related Topics Hash Table Heap

package leetcode.editor.en;

import javafx.scene.layout.Priority;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparing(map::get));
            for (Integer n : map.keySet()) {
                minHeap.offer(n);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
            List<Integer> ret = new ArrayList<>();
            while (!minHeap.isEmpty()) {
                ret.add(minHeap.poll());
            }
            Collections.reverse(ret);
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
