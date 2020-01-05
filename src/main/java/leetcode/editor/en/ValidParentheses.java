//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// Note that an empty string is also considered valid. 
//
// Example 1: 
//
// 
//Input: "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: "{[]}"
//Output: true
// 
// Related Topics String Stack
package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> map = new HashMap<Character, Character>() {{
                put('(', ')');
                put('{', '}');
                put('[', ']');
            }};
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    stack.push(map.get(c));
                } else {
                    if (stack.isEmpty() || !stack.pop().equals(c)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
