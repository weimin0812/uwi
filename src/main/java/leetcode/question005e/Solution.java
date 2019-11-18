package leetcode.question005e;

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        int n = s.length();
        String ret = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (i == j) {
                    dp[i][j] = true;
                } else if (j == i + 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }

                if (dp[i][j] && j - i + 1 > ret.length()) {
                    ret = s.substring(i, j + 1);
                }
            }
        }

        return ret;
    }




}
