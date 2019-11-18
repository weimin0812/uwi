package swordoffer.question02;

public class Solution {
    // 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    // 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuffer ret = new StringBuffer();
        for (char c : str.toString().toCharArray()) {
            ret.append(c == ' ' ? "%20" : c);
        }
        return ret.toString();
    }
}
