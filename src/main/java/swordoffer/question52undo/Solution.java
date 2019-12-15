package swordoffer.question52undo;

public class Solution {
    // 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
    // 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
//    public boolean isMatch(String text, String pattern) {
//        if (pattern.isEmpty()) return text.isEmpty();
//        boolean first_match = (!text.isEmpty() &&
//                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
//
//        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
//            return (isMatch(text, pattern.substring(2)) ||
//                    (first_match && isMatch(text.substring(1), pattern)));
//        } else {
//            return first_match && isMatch(text.substring(1), pattern.substring(1));
//        }
//    }
    public static void main(String[] args) {
        String s = "aa";
        s = s.substring(2);
        String p = "a*";
        Solution solution = new Solution();
        boolean match = solution.isMatch(s, p);
        System.out.println(match);
    }

    // todo sth wrong
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return s == p;
        }
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean first_match = !s.isEmpty() && s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
        if (p.length() > 1 && p.charAt(1) == '*') {
            // 短路
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}

