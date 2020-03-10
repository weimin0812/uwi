//Given a string S and a string T, find the minimum window in S which will conta
//in all the characters in T in complexity O(n). 
//
// Example: 
//
// 
//Input: S = "ADOBECODEBANC", T = "ABC"
//Output: "BANC"
// 
//
// Note: 
//
// 
// If there is no such window in S that covers all characters in T, return the e
//mpty string "". 
// If there is such window, you are guaranteed that there will always be only on
//e unique minimum window in S. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window

package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> needs = new HashMap<>();
            for (char c : t.toCharArray()) {
                needs.put(c, needs.getOrDefault(c, 0) + 1);
            }
            int l = 0, count = 0, total = t.length();
            Map<Character, Integer> windows = new HashMap<>();
            String ret = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (needs.containsKey(c)) {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                    if (windows.get(c) <= needs.get(c)) {
                        count++;
                    }
                }
                while (count == total) {
                    if ("".equals(ret) || ret.length() > (i - l + 1)) {
                        ret = s.substring(l, i + 1);
                    }
                    char lc = s.charAt(l);
                    if (needs.containsKey(lc)) {
                        windows.put(lc, windows.get(lc) - 1);
                        if (windows.get(lc) < needs.get(lc)) {
                            count--;
                        }
                    }
                    l++;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
