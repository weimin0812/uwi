//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000. 
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
        String s = "";
        System.out.println(solution.longestPalindrome(s));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            int start = 0, end = -1;
            for (int d = 0; d < s.length(); d++) {
                for (int i = 0; i < s.length() - d; i++) {
                    int j = i + d;
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && (i + 1 > j - 1 || dp[i + 1][j - 1]);
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
