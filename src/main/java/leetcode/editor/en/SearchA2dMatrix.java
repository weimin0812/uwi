//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// Example 1: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//Output: false 
// Related Topics Array Binary Search

package leetcode.editor.en;

public class SearchA2dMatrix {

    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int l = 0, h = matrix.length * matrix[0].length - 1;
            while (l <= h) {
                int m = l + (h - l) / 2;
                int n = matrix[m / matrix[0].length][m % matrix[0].length];
                if (n == target) {
                    return true;
                } else if (n < target) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
