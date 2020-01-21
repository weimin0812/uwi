//
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
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

import java.util.*;

public class GenerateParentheses {

    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        for (String s : solution.generateParenthesis(3)) {
            System.out.println(s);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ret = new ArrayList<>();
            dfs(0, 0, n, new StringBuffer(), ret);
            return ret;
        }

        private void dfs(int open, int close, int n, StringBuffer sb, List<String> ret) {
            if (open == n && close == n) {
                ret.add(sb.toString());
            }
            if (open < n) {
                sb.append('(');
                dfs(open + 1, close, n, sb, ret);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (close < open) {
                sb.append(')');
                dfs(open, close + 1, n, sb, ret);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
