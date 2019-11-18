package leetcode.question020;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()";
        System.out.println(solution.isValid(s));
    }

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }
        };

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else {
                if (stack.isEmpty() || !stack.pop().equals(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
