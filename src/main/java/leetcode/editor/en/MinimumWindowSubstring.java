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
            if (s == null || s.length() == 0 || t == null || t.length() == 0) {
                return "";
            }
            Map<Character, Integer> needs = new HashMap<>();
            for (char c : t.toCharArray()) {
                needs.put(c, needs.getOrDefault(c, 0) + 1);
            }
            int l = 0, r = 0, total = 0;
            int start = -1, minLength = Integer.MAX_VALUE;
            Map<Character, Integer> windows = new HashMap<>();
            for (; r < s.length(); r++) {
                char rc = s.charAt(r);
                if (needs.containsKey(rc)) {
                    windows.put(rc, windows.getOrDefault(rc, 0) + 1);
                    if (windows.get(rc) <= needs.get(rc)) {
                        total++;
                    }
                }
                while (total == t.length()) {
                    if (r - l + 1 < minLength) {
                        start = l;
                        minLength = r - l + 1;
                    }
                    char lc = s.charAt(l);
                    if (needs.containsKey(lc)) {
                        windows.put(lc, windows.get(lc) - 1);
                        if (windows.get(lc) < needs.get(lc)) {
                            total--;
                        }
                    }
                    l++;
                }
            }
            return start == -1 ? "" : s.substring(start, start + minLength);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
