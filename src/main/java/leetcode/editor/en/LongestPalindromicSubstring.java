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
            if (s == null || s.length() == 0) {
                return "";
            }
            start = 0;
            end = 0;
            for (int i = 0; i < s.length(); i++) {
                expand(s, i, i);
                expand(s, i, i + 1);
            }
            return s.substring(start + 1, end);
        }

        private void expand(String s, int l, int h) {
            while (l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)) {
                l--;
                h++;
            }
            if (h - l > end - start) {
                start = l;
                end = h;
            }
        }


    }


//leetcode submit region end(Prohibit modification and deletion)

}
