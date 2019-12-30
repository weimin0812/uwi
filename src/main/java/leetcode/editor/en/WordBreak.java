//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
//
// Note: 
//
// 
// The same word in the dictionary may be reused multiple times in the segmentation. 
// You may assume the dictionary does not contain duplicate words. 
// 
//
// Example 1: 
//
// 
//Input: s = "leetcode", wordDict = ["leet", "code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
// 
//
// Example 2: 
//
// 
//Input: s = "applepenapple", wordDict = ["apple", "pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//             Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//Output: false
// 
// Related Topics Dynamic Programming
package leetcode.editor.en;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public boolean wordBreak(String s, List<String> wordDict) {
//            Set<String> wordDictSet = new HashSet<>(wordDict);
//            boolean[] dp = new boolean[s.length() + 1];
//            dp[0] = true;
//            for (int i = 1; i <= s.length(); i++) {
//                for (int j = 0; j < i; j++) {
//                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
//                        dp[i] = true;
//                        break;
//                    }
//                }
//            }
//            return dp[s.length()];
//        }

        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet<>(wordDict);
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[s.length()];
            queue.add(0);
            while (!queue.isEmpty()) {
                int start = queue.remove();
                if (!visited[start]) {
                    for (int end = start + 1; end <= s.length(); end++) {
                        if (wordDictSet.contains(s.substring(start, end))) {
                            queue.add(end);
                            if (end == s.length()) {
                                return true;
                            }
                        }
                    }
                    visited[start] = true;
                }
            }
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
