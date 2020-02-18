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
            generateParenthesis(n, 0, 0, new StringBuffer(), ret);
            return ret;
        }

        private void generateParenthesis(int n, int open, int close, StringBuffer sb, List<String> ret) {
            if (open == n && close == n) {
                ret.add(sb.toString());
                return;
            }
            if (open < n) {
                sb.append('(');
                generateParenthesis(n, open + 1, close, sb, ret);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (close < open) {
                sb.append(')');
                generateParenthesis(n, open, close + 1, sb, ret);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
