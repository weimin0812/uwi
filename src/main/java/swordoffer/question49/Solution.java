package swordoffer.question49;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int toInt = solution.StrToInt(String.valueOf(Integer.MIN_VALUE));
        System.out.println(toInt);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

    // 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
    // 输入描述:
    // 输入一个字符串,包括数字字母符号,可以为空
    // 输出描述:
    // 如果是合法的数值表达则返回该数字，否则返回0
    // -2147483649
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean negative = false;
        int index = 0;
        char first = str.charAt(0);
        if (!Character.isDigit(first)) {
            if (first == '+' || first == '-') {
                index++;
                if (first == '-') {
                    negative = true;
                }
            } else {
                return 0;
            }
        }
        int ret = 0;
        for (; index < str.length(); index++) {
            if (!Character.isDigit(str.charAt(index))) {
                return 0;
            }
            int digit = Character.getNumericValue(str.charAt(index));
            if (negative) {
                if (ret >= Integer.MAX_VALUE / 10 && Character.getNumericValue(str.charAt(index)) > (Integer.MAX_VALUE % 10 + 1)) {
                    return 0;
                }
            } else {
                if (ret >= Integer.MAX_VALUE / 10 && Character.getNumericValue(str.charAt(index)) > (Integer.MAX_VALUE % 10)) {
                    return 0;
                }
            }
            ret = ret * 10 + digit;
        }
        ret = negative ? -ret : ret;
        return ret;
    }

}
