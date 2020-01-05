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
            List<String> list = new ArrayList<>();
            dfs(0, 0, n, new StringBuffer(), list);
            return list;
        }

        private void dfs(int open, int close, int n, StringBuffer sb, List<String> list) {
            if (sb.length() == 2 * n) {
                list.add(sb.toString());
                return;
            }
            if (open < n) {
                sb.append('(');
                dfs(open + 1, close, n, sb, list);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (close < open) {
                sb.append(')');
                dfs(open, close + 1, n, sb, list);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        private void dfs(int i, int n, StringBuffer sb, List<String> list) {
            if (i == n) {
                if (valid(sb.toString())) {
                    list.add(sb.toString());
                }
                return;
            }
            for (char c : "()".toCharArray()) {
                sb.append(c);
                dfs(i + 1, n, sb, list);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        private boolean valid(String s) {
            int balance = 0;
            for (char c : s.toCharArray()) {
                if (c == ')') {
                    balance++;
                } else {
                    balance--;
                    if (balance < 0) {
                        return false;
                    }
                }
            }
            return balance == 0;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
