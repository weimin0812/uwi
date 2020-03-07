//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ret = new ArrayList<>();
            if (n <= 0) {
                return ret;
            }
            generateParenthesis(0, 0, n, ret, new StringBuilder());
            return ret;
        }

        private void generateParenthesis(int open, int close, int n, List<String> ret, StringBuilder sb) {
            if (open == n && close == n) {
                ret.add(sb.toString());
                return;
            }
            if (open < n) {
                sb.append('(');
                generateParenthesis(open + 1, close, n, ret, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (close < open) {
                sb.append(')');
                generateParenthesis(open, close + 1, n, ret, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
