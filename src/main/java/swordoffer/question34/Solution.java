package swordoffer.question34;

public class Solution {
    // 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        int[] count = new int[256];
        for (char c : str.toCharArray()) {
            count[c]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
