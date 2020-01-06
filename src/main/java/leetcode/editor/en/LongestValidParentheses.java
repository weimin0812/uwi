//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring. 
//
// Example 1: 
//
// 
//Input: "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()"
// 
//
// Example 2: 
//
// 
//Input: ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()"
// 
// Related Topics String Dynamic Programming
package leetcode.editor.en;

public class LongestValidParentheses {

    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            // longest valid parentheses
            int[] dp = new int[s.length()];
            int ret = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                    } else {
                        int index = i - 1 - dp[i - 1];
                        if (index >= 0 && s.charAt(index) == '(') {
                            dp[i] = dp[i - 1] + (index - 1 >= 0 ? dp[index - 1] : 0) + 2;
                        }
                    }
                    ret = Math.max(ret, dp[i]);
                }
            }
            return ret;
        }

        // todo stack
        // todo 不需要辅助内存









    }
//leetcode submit region end(Prohibit modification and deletion)

}
