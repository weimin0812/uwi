//
//Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
// 
//For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
// 
//
// Note:
//The length of temperatures will be in the range [1, 30000].
//Each temperature will be an integer in the range [30, 100].
// Related Topics Hash Table Stack
package leetcode.editor.en;

import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            if (T == null || T.length == 0) {
                return T;
            }
            int[] ret = new int[T.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < T.length; i++) {
                while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                    ret[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
