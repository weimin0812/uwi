//Given a string, find the length of the longest substring without repeating characters. 
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
//             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
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
        String s = "abcabcbb";
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            int index = -1;
            int ret = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    index = Math.max(index, map.get(c));
                }
                map.put(c, i);
                ret = Math.max(ret, i - index);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
