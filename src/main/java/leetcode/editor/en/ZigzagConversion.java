//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a number of rows: 
//
// 
//string convert(string s, int numRows); 
//
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//
//P     I    N
//A   L S  I G
//Y A   H R
//P     I 
// Related Topics String
package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (s == null || s.length() == 0 || numRows <= 1) {
                return s;
            }
            int size = Math.min(s.length(), numRows);
            List<StringBuffer> rows = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                rows.add(new StringBuffer());
            }
            int currentRow = 0;
            boolean down = true;
            for (char c : s.toCharArray()) {
                rows.get(currentRow).append(c);
                if (currentRow == 0) {
                    down = true;
                } else if (currentRow == size - 1) {
                    down = false;
                }
                currentRow += down ? 1 : -1;
            }
            StringBuffer ret = new StringBuffer();
            rows.forEach(r -> ret.append(r));
            return ret.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
