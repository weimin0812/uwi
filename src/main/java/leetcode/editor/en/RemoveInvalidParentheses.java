//Remove the minimum number of invalid parentheses in order to make the input st
//ring valid. Return all possible results. 
//
// Note: The input string may contain letters other than the parentheses ( and )
//. 
//
// Example 1: 
//
// 
//Input: "()())()"
//Output: ["()()()", "(())()"]
// 
//
// Example 2: 
//
// 
//Input: "(a)())()"
//Output: ["(a)()()", "(a())()"]
// 
//
// Example 3: 
//
// 
//Input: ")("
//Output: [""]
// Related Topics Depth-first Search Breadth-first Search

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        Solution solution = new RemoveInvalidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> ans = new ArrayList<>();
            remove(s, ans, 0, 0, new char[]{'(', ')'});
            return ans;
        }
        private void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
            for (int stack = 0, i = last_i; i < s.length(); i++) {
                if (s.charAt(i) == par[0]) {
                    stack++;
                }
                if (s.charAt(i) == par[1]) {
                    stack--;
                }
                if (stack >= 0) {
                    continue;
                }
                for (int j = last_j; j <= i; j++) {

                }
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
