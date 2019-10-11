package question022;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        List<String> ret = solution.generateParenthesis1(n);
        System.out.println(ret);
    }

    // 不用全部生成、合法的才生成
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n <= 0) {
            return ret;
        }
        backtrack(ret, 0, 0, n, new StringBuilder());
        return ret;
    }

    private void backtrack(List<String> ret, int open, int close, int n, StringBuilder sb) {
        if (open == n && close == n) {
            ret.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            backtrack(ret, open + 1, close, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            backtrack(ret, open, close + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public List<String> generateParenthesis1(int n) {
        List<String> ret = new ArrayList<>();
        if (n <= 0) {
            return ret;
        }

        dfs(0, 2 * n, ret, new StringBuilder());
        return ret;
    }

    private void dfs(int i, int n, List<String> ret, StringBuilder sb) {
        if (i == n) {
            if (isValid(sb.toString())) {
                ret.add(sb.toString());
            }
            return;
        }

        char[] chars = "()".toCharArray();
        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];
            sb.append(c);
            dfs(i + 1, n, ret, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty() || !stack.pop().equals(')')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
