//Given an array of strings, group anagrams together. 
//
// Example: 
//
// 
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// Note: 
//
// 
// All inputs will be in lowercase. 
// The order of your output does not matter. 
// 
// Related Topics Hash Table String

package leetcode.editor.en;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
