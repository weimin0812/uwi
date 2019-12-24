//A message containing letters from A-Z is being encoded to numbers using the following mapping: 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// Given a non-empty string containing only digits, determine the total number of ways to decode it. 
//
// Example 1: 
//
// 
//Input: "12"
//Output: 2
//Explanation: It could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: "226"
//Output: 3
//Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6). 
// Related Topics String Dynamic Programming
package leetcode.editor.en;

public class DecodeWays {

    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        String s = "12";
        int numDecodings = solution.numDecodings(s);
        System.out.println(numDecodings);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0 || s.charAt(0) == '0') {
                return 0;
            }
            int n = s.length();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                int first = Integer.valueOf(s.substring(i - 1, i));
                int second = Integer.valueOf(s.substring(i - 2, i));
                if (0 < first && first <= 9) {
                    dp[i] += dp[i - 1];
                }
                if (10 <= second && second <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
