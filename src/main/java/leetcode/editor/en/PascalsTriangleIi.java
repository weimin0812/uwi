//Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle. 
//
// Note that the row index starts from 0. 
//
// 
//In Pascal's triangle, each number is the sum of the two numbers directly above it. 
//
// Example: 
//
// 
//Input: 3
//Output: [1,3,3,1]
// 
//
// Follow up: 
//
// Could you optimize your algorithm to use only O(k) extra space? 
// Related Topics Array
package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi {

    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        System.out.println(solution.getRow(3));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            if (rowIndex < 0) {
                return new ArrayList<>();
            }
            List<List<Integer>> ret = new ArrayList<>();
            List<Integer> first = new ArrayList<>();
            first.add(1);
            ret.add(first);
            for (int i = 0; i < rowIndex; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                List<Integer> pre = ret.get(i);
                for (int j = 1; j < i + 1; j++) {
                    list.add(pre.get(j) + pre.get(j - 1));
                }
                list.add(1);
                ret.add(list);
            }
            return ret.get(rowIndex);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
