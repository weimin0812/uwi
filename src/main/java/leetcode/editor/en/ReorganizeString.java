//Given a string S, check if the letters can be rearranged so that two character
//s that are adjacent to each other are not the same. 
//
// If possible, output any possible result. If not possible, return the empty st
//ring. 
//
// Example 1: 
//
// 
//Input: S = "aab"
//Output: "aba"
// 
//
// Example 2: 
//
// 
//Input: S = "aaab"
//Output: ""
// 
//
// Note: 
//
// 
// S will consist of lowercase letters and have length in range [1, 500]. 
// 
//
// 
// Related Topics String Heap Greedy Sort

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class ReorganizeString {

    public static void main(String[] args) {
        Solution solution = new ReorganizeString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorganizeString(String S) {
            //不能有元素的个数超过
            // 2 1
            // 3 2
            // 4 3
            //
            List<String> ret = new ArrayList<>();
            boolean[] visited = new boolean[S.length()];
            dfs(S, 0, visited, ret, new StringBuffer());
            return ret.isEmpty() ? "" : ret.get(0);
        }

        private void dfs(String s, int index, boolean[] visited, List<String> ret, StringBuffer sb) {
            if (index == s.length()) {
                ret.add(sb.toString());
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                if (!visited[i] && (sb.toString().isEmpty() || sb.charAt(sb.length() - 1) != s.charAt(i))) {
                    visited[i] = true;
                    sb.append(s.charAt(i));
                    dfs(s, index + 1, visited, ret, sb);
                    visited[i] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
