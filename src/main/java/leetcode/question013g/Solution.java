package leetcode.question013g;

public class Solution {
    // "MCMXCIV"

    public static void main(String[] args) {
        String s = "LVIII";
        Solution solution = new Solution();
        System.out.println(solution.romanToInt(s));
    }

    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int ret = 0;
        for (int i = 0; i < romans.length; i++) {
            while (s.startsWith(romans[i])) {
                ret += values[i];
                s = s.substring(s.indexOf(romans[i]) + romans[i].length());
            }
        }

        return ret;
    }
}
