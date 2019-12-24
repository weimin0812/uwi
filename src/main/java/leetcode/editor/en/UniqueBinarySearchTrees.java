//Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n? 
//
// Example: 
//
// 
//Input: 3
//Output: 5
//Explanation:
//Given n = 3, there are a total of 5 unique BST's:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics Dynamic Programming Tree
package leetcode.editor.en;

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        int n = 3;
        int trees = solution.numTrees(n);
        System.out.println(trees);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            // dp[n]代表长度为n的个数
            // dp[0] = 1 dp[1] = 1
            // dp[n] = f(i,n) i = 1,...,n
            // f(i,n) = dp[i-1] + dp[n-i]
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
