//Given an encoded string, return its decoded string. 
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the 
//square brackets is being repeated exactly k times. Note that k is guaranteed to 
//be a positive integer. 
//
// You may assume that the input string is always valid; No extra white spaces, 
//square brackets are well-formed, etc. 
//
// Furthermore, you may assume that the original data does not contain any digit
//s and that digits are only for those repeat numbers, k. For example, there won't
// be input like 3a or 2[4]. 
//
// Examples: 
//
// 
//s = "3[a]2[bc]", return "aaabcbc".
//s = "3[a2[c]]", return "accaccacc".
//s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
// 
//
// 
// Related Topics Stack Depth-first Search

package leetcode.editor.en;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            if (s == null || s.isEmpty()) {
                return s;
            }
            Stack<Integer> countStack = new Stack<>();
            Stack<String> strStack = new Stack<>();
            String res = "";
            int index = 0;
            while (index < s.length()) {
                char c = s.charAt(index);
                if (Character.isDigit(c)) {
                    int count = 0;
                    while (Character.isDigit(s.charAt(index))) {
                        count = count * 10 + s.charAt(index) - '0';
                        index++;
                    }
                    countStack.push(count);
                } else if (c == '[') {
                    strStack.push(res);
                    res = "";
                    index++;
                } else if (c == ']') {
                    StringBuilder sb = new StringBuilder(strStack.pop());
                    int repeatTimes = countStack.pop();
                    for (int i = 0; i < repeatTimes; i++) {
                        sb.append(res);
                    }
                    res = sb.toString();
                    index++;
                } else {
                    res = res + c;
                    index++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
