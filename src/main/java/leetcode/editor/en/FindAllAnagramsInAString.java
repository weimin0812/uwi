//Given a string s and a non-empty string p, find all the start indices of p's a
//nagrams in s. 
//
// Strings consists of lowercase English letters only and the length of both str
//ings s and p will not be larger than 20,100. 
//
// The order of output does not matter. 
//
// Example 1:
// 
//Input:
//s: "cbaebabacd" p: "abc"
//
//Output:
//[0, 6]
//
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
// 
//
// Example 2:
// 
//Input:
//s: "abab" p: "ab"
//
//Output:
//[0, 1, 2]
//
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
// Related Topics Hash Table

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if (s == null || s.isEmpty() || p == null || p.isEmpty()) {
                return new ArrayList<>();
            }
            Map<Character, Integer> needs = new HashMap<>();
            for (char c : p.toCharArray()) {
                needs.put(c, needs.getOrDefault(c, 0) + 1);
            }
            Map<Character, Integer> windows = new HashMap<>();
            int l = 0, r = 0, count = 0, length = p.length();
            List<Integer> ret = new ArrayList<>();
            while (r < s.length()) {
                char c = s.charAt(r);
                if (needs.containsKey(c)) {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                    if (windows.get(c) <= needs.get(c)) {
                        count++;
                    }
                }
                while (count == length) {
                    if (r - l + 1 == length) {
                        ret.add(l);
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
                r++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
