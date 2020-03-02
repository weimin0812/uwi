package ebay;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String s = "[{}]";
        System.out.println(solution2.match(s));
        s = "[][]{}";
        System.out.println(solution2.match(s));
        s = "[]]";
        System.out.println(solution2.match(s));
    }

    public boolean match(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
