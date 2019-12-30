//Given a 32-bit signed integer, reverse digits of an integer. 
//
// Example 1: 
//
// 
//Input: 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: 120
//Output: 21
// 
//
// Note: 
//Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows. 
// Related Topics Math
package leetcode.editor.en;

public class ReverseInteger {

    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int num = x, ret = 0;
            while (num != 0) {
                int digit = num % 10;
                num /= 10;
                int t = ret;
                ret = ret * 10 + digit;
                if (ret / 10 != t) {
                    return 0;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
