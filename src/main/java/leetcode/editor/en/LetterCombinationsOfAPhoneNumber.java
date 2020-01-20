//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
//
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters. 
//
// 
//
// Example: 
//
// 
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// Note: 
//
// Although the above answer is in lexicographical order, your answer could be in any order you want. 
// Related Topics String Backtracking
package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> ret = new ArrayList<>();
            if (digits == null || digits.isEmpty()) {
                return ret;
            }
            String[] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            dfs(0, new StringBuffer(), digits, ret, numbers);
            return ret;
        }

        private void dfs(int index, StringBuffer sb, String digits, List<String> ret, String[] numbers) {
            if (index == digits.length()) {
                ret.add(sb.toString());
                return;
            }
            for (char c : numbers[(digits.charAt(index) - '0')].toCharArray()) {
                sb.append(c);
                dfs(index + 1, sb, digits, ret, numbers);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
