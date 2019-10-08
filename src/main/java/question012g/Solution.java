package question012g;

public class Solution {
    // I             1
    // V             5
    // X             10
    // L             50
    // C             100
    // D             500
    // M             1000
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                ret.append(romans[i]);
                num -= values[i];
            }
        }

        return ret.toString();
    }
}
