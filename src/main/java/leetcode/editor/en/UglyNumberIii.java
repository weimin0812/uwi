//Write a program to find the n-th ugly number. 
//
// Ugly numbers are positive integers which are divisible by a or b or c. 
//
// 
// Example 1: 
//
// 
//Input: n = 3, a = 2, b = 3, c = 5
//Output: 4
//Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4. 
//
// Example 2: 
//
// 
//Input: n = 4, a = 2, b = 3, c = 4
//Output: 6
//Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
// 
//
// Example 3: 
//
// 
//Input: n = 5, a = 2, b = 11, c = 13
//Output: 10
//Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
// 
//
// Example 4: 
//
// 
//Input: n = 1000000000, a = 2, b = 217983653, c = 336916467
//Output: 1999999984
// 
//
// 
// Constraints: 
//
// 
// 1 <= n, a, b, c <= 10^9 
// 1 <= a * b * c <= 10^18 
// It's guaranteed that the result will be in range [1, 2 * 10^9] 
// 
// Related Topics Math Binary Search
package leetcode.editor.en;

public class UglyNumberIii {

    public static void main(String[] args) {
        Solution solution = new UglyNumberIii().new Solution();
        int n = 1000000000, a = 2, b = 217983653, c = 336916467;
        int nthUglyNumber = solution.nthUglyNumber(n, a, b, c);
        System.out.println(nthUglyNumber);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n, int a, int b, int c) {
            //todo 到底哪儿有问题
            int l = Math.min(a, Math.min(b, c)), h = 2_000_000_000;
            while (l <= h) {
                int m = l + (h - l) / 2;
                int count = uglyCount(m, a, b, c);
                if (count == n) {
                    return m - Math.min(m % a, Math.min(m % b, m % c));
                } else if (count > n) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return 0;
        }

        private int uglyCount(int n, int a, int b, int c) {
            return n / a + n / b + n / c - n / lcm(a, b) - n / lcm(a, c) - n / lcm(b, c) + n / lcm(a * b, c);
        }

        private int lcm(int a, int b) {
            return a * b / gcd(a, b);
        }

        private int gcd(int a, int b) {
            while (b > 0) {
                int t = b;
                b = a % b;
                a = t;
            }
            return a;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
