//Given a string s, find the longest palindromic substring in s. You may assume 
//that the maximum length of s is 1000. 
//
// Example 1: 
//
// 
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: "cbbd"
//Output: "bb"
// 
// Related Topics String Dynamic Programming

package leetcode.editor.en;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            int n = s.length();
            int start = -1, end = -2;
            boolean[][] dp = new boolean[n][n];
            //dp[i][j] = s[i] == s[j] && dp[i+1][j-1]
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 > j - 1 || dp[i + 1][j - 1]);
                    if (dp[i][j]) {
                        if (j - i > end - start) {
                            start = i;
                            end = j;
                        }
                    }
                }
            }
            return s.substring(start, end + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
