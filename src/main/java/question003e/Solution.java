package question003e;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    // Input: "pwwkew"
    // Output: 3
    // Explanation: The answer is "wke", with the length of 3.
    // Note that the answer must be a substring, "pwke" is a
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int ret = 0;
        HashSet<Character> set = new HashSet<>();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (!set.isEmpty() && set.contains(c)) {
                set.remove(s.charAt(index));
                index++;
            }
            set.add(c);
            ret = Math.max(ret, set.size());
        }

        return ret;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null) {
            return 0;
        }
        int ret = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            ret = Math.max(ret, i - left + 1);
        }

        return ret;
    }


}
