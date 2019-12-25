//
//Given a string s and a string t, check if s is subsequence of t.
// 
//
// 
//You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
// 
//
// 
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
// 
//
// Example 1: 
//s = "abc", t = "ahbgdc"
// 
// 
//Return true.
// 
//
// Example 2: 
//s = "axc", t = "ahbgdc"
// 
// 
//Return false.
// 
//
// Follow up: 
//If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code? 
//
// Credits: Special thanks to @pbrother for adding this problem and creating all test cases. Related Topics Binary Search Dynamic Programming Greedy
package leetcode.editor.en;

public class IsSubsequence {

 public static void main(String[] args) {
        Solution solution = new IsSubsequence().new Solution();
 }



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return s == t;
        }
        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length()) {
            while (tIndex < t.length() && s.charAt(sIndex) != t.charAt(tIndex)) {
                tIndex++;
            }
            if (tIndex >= t.length()) {
                return false;
            }
            sIndex++;
            tIndex++;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
