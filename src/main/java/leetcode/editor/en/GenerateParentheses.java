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
            generateParenthesis(ret, n, 0, 0, new StringBuilder());
            return ret;
        }

        private void generateParenthesis(List<String> ret, int n, int open, int close, StringBuilder sb) {
            if (open == n && close == n) {
                ret.add(sb.toString());
                return;
            }
            if (open < n) {
                sb.append('(');
                generateParenthesis(ret, n, open + 1, close, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (close < open) {
                sb.append(')');
                generateParenthesis(ret, n, open, close + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
