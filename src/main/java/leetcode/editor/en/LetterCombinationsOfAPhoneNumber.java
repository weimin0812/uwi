//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. 
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
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
// Although the above answer is in lexicographical order, your answer could be i
//n any order you want. 
// Related Topics String Backtracking

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

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
            String[] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
            letterCombinations(digits, 0, ret, new StringBuffer(), numbers);
            return ret;
        }

        private void letterCombinations(String digits, int i, List<String> ret, StringBuffer sb, String[] numbers) {
            if (i == digits.length()) {
                ret.add(sb.toString());
                return;
            }
            for (char c : numbers[digits.charAt(i) - '0'].toCharArray()) {
                sb.append(c);
                letterCombinations(digits, i + 1, ret, sb, numbers);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
