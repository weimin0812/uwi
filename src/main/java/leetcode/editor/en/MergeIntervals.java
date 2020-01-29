//Given a collection of intervals, merge all overlapping intervals. 
//
// Example 1: 
//
// 
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping. 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature. 
// Related Topics Array Sort
package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length <= 1) {
                return intervals;
            }
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            List<int[]> ret = new ArrayList<>();
            int[] pre = intervals[0];
            ret.add(pre);
            for (int i = 1; i < intervals.length; i++) {
                int[] current = intervals[i];
                if (current[0] <= pre[1]) {
                    pre[1] = Math.max(current[1], pre[1]);
                } else {
                    ret.add(current);
                    pre = current;
                }
            }
            return ret.toArray(new int[ret.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}