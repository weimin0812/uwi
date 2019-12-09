package swordoffer.question53;

public class Solution {
    // 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
    // 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
    // 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
    public boolean isNumeric(char[] str) {
        // e split str
        // first part double
        // second part integer
        if (str == null || str.length == 0) {
            return false;
        }
        String number = new String(str).toLowerCase();
        int eIndex = number.indexOf('e');
        if (eIndex >= 0) {
            String first = number.substring(0, eIndex);
            String second = number.substring(eIndex + 1);
            return isNumber(first, true) && isNumber(second, false);
        } else {
            return isNumber(number, true);
        }
    }

    private boolean isNumber(String num, boolean isDouble) {
        if (num == null || num.isEmpty()) {
            return false;
        }
        int index = 0;
        char first = num.charAt(0);
        if (!Character.isDigit(first)) {
            if (first == '+' || first == '-') {
                index++;
            } else {
                return false;
            }
        }

        int dot = 0;
        for (; index < num.length(); index++) {
            char c = num.charAt(index);
            if (!Character.isDigit(c)) {
                if (isDouble) {
                    if (c == '.') {
                        dot++;
                        if (dot > 1 || index == num.length() - 1) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
