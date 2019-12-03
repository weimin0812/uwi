package swordoffer.question43;

public class Solution {

    // S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n <= 0) {
            return str;
        }
        n = n % str.length();

        return str.substring(n) + str.substring(0, n);
    }
}
