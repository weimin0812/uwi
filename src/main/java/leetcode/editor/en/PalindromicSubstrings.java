//Given a string, your task is to count how many palindromic substrings in this string. 
//
// The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters. 
//
// Example 1: 
//
// 
//Input: "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
// 
//
// 
//
// Example 2: 
//
// 
//Input: "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 
//
// Note: 
//
// 
// The input string length won't exceed 1000. 
// 
//
// Related Topics String Dynamic Programming
package leetcode.editor.en;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            boolean[][] dp = new boolean[s.length()][s.length()];
            int count = 0;
            // todo 大意了吧 dp一定要注意扫表的顺序
            // todo
            for (int d = 0; d < s.length(); d++) {
                for (int i = 0; i < s.length() - d; i++) {
                    int j = i + d;
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && (i + 1 > j - 1 || dp[i + 1][j - 1]);
                    if (dp[i][j]) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
