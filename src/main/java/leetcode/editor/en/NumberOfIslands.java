//Given a 2d grid map of '1's (land) and '0's (water), count the number of islan
//ds. An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all su
//rrounded by water. 
//
// Example 1: 
//
// 
//Input:
//11110
//11010
//11000
//00000
//
//Output: 1
// 
//
// Example 2: 
//
// 
//Input:
//11000
//11000
//00100
//00011
//
//Output: 3
// Related Topics Depth-first Search Breadth-first Search Union Find

package leetcode.editor.en;

public class NumberOfIslands {

    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            if (grid == null) {
                return count;
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] g, int i, int j) {
            if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] != '1') {
                return;
            }
            g[i][j] = '0';
            dfs(g, i + 1, j);
            dfs(g, i - 1, j);
            dfs(g, i, j + 1);
            dfs(g, i, j - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
