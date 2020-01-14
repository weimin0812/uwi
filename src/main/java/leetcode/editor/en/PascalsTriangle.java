//Given a non-negative integer numRows, generate the first numRows of Pascal's triangle. 
//
// 
//In Pascal's triangle, each number is the sum of the two numbers directly above it. 
//
// Example: 
//
// 
//Input: 5
//Output:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// 
// Related Topics Array
package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        solution.generate(5);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ret = new ArrayList<>();
            if (numRows < 1) {
                return ret;
            }
            List<Integer> first = new ArrayList<>();
            first.add(1);
            ret.add(first);
            for (int i = 1; i < numRows; i++) {
                List<Integer> pre = ret.get(i - 1);
                List<Integer> list = new ArrayList<>();
                list.add(1);
                for (int j = 1; j < i; j++) {
                    list.add(pre.get(j) + pre.get(j - 1));
                }
                list.add(1);
                ret.add(list);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
