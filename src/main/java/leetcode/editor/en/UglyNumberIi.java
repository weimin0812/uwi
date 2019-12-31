//Write a program to find the n-th ugly number. 
//
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
//
// Example: 
//
// 
//Input: n = 10
//Output: 12
//Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers. 
//
// Note: 
//
// 
// 1 is typically treated as an ugly number. 
// n does not exceed 1690. 
// Related Topics Math Dynamic Programming Heap
package leetcode.editor.en;

public class UglyNumberIi {

    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            if (n < 1) {
                return 0;
            }
            int[] ugly = new int[n];
            ugly[0] = 1;
            int index2 = 0, index3 = 0, index5 = 0;
            for (int i = 1; i < n; i++) {
                ugly[i] = Math.min(Math.min(ugly[index2] * 2, ugly[index3] * 3), ugly[index5] * 5);
                if (ugly[i] == ugly[index2] * 2) {
                    index2++;
                }
                if (ugly[i] == ugly[index3] * 3) {
                    index3++;
                }
                if (ugly[i] == ugly[index5] * 5) {
                    index5++;
                }
            }
            return ugly[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
