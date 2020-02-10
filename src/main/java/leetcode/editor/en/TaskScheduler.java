//Given a char array representing tasks CPU need to do. It contains capital lett
//ers A to Z where different letters represent different tasks. Tasks could be don
//e without original order. Each task could be done in one interval. For each inte
//rval, CPU could finish one task or just be idle. 
//
// However, there is a non-negative cooling interval n that means between two sa
//me tasks, there must be at least n intervals that CPU are doing different tasks 
//or just be idle. 
//
// You need to return the least number of intervals the CPU will take to finish 
//all the given tasks. 
//
// 
//
// Example: 
//
// 
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
// 
//
// 
//
// Note: 
//
// 
// The number of tasks is in the range [1, 10000]. 
// The integer n is in the range [0, 100]. 
// 
// Related Topics Array Greedy Queue

package leetcode.editor.en;

public class TaskScheduler {

    public static void main(String[] args) {
        Solution solution = new TaskScheduler().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
