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
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int start = 0;
        private int end = 0;

        public String longestPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return "";
            }
            for (int i = 0; i < s.length(); i++) {
                expandAroundCenter(s, i, i);
                expandAroundCenter(s, i, i + 1);
            }
            return s.substring(start + 1, end);
        }

        private void expandAroundCenter(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l > end - start) {
                start = l;
                end = r;
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
