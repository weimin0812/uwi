//Given a string, find the length of the longest substring without repeating cha
//racters. 
//
// 
// Example 1: 
//
// 
//Input: "abcabcbb"
//Output: 3 
//Explanation: The answer is "abc", with the length of 3. 
// 
//
// 
// Example 2: 
//
// 
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// 
// Example 3: 
//
// 
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence
// and not a substring.
// 
// 
// 
// 
// Related Topics Hash Table Two Pointers String Sliding Window

package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> windows = new HashMap<>();
            int l = 0, r = 0, ret = 0;
            while (r < s.length()) {
                char c = s.charAt(r);
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                while (windows.get(c) > 1) {
                    char lc = s.charAt(l);
                    windows.put(lc, windows.get(lc) - 1);
                    l++;
                }
                ret = Math.max(ret, r - l + 1);
                r++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
