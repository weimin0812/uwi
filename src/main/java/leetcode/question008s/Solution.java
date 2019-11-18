package leetcode.question008s;

public class Solution {
    public int myAtoi(String str) {
        int ret = 0;
        if (str == null || str.length() == 0) {
            return ret;
        }

        str = str.trim();
        if (str == null || str.length() == 0) {
            return ret;
        }
        char first = str.charAt(0);
        boolean negative = false;
        int index = 0;
        if (!Character.isDigit(first)) {
            if (first == '+') {
                index = 1;
            } else if (first == '-') {
                negative = true;
                index = 1;
            } else {
                return ret;
            }
        }

        for (; index < str.length(); index++) {
            if (!Character.isDigit(str.charAt(index))) {
                return negative ? -ret : ret;
            }
            int c = str.charAt(index) - '0';
            ret = ret * 10 + c;
            if (index != str.length() - 1) {
                if (negative) {
                    if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && str.charAt(index + 1) > '8') {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && str.charAt(index + 1) > '7') {
                        return Integer.MAX_VALUE;
                    }
                }
            }
        }
        return negative ? -ret : ret;
    }
}
