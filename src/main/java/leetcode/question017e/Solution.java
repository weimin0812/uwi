package leetcode.question017e;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    String[] letters = {
            "",
            "",
            "abc",// 2
            "def",// 3
            "ghi",// 4
            "jkl",// 5
            "mno",// 6
            "pqrs",// 7
            "tuv",// 8
            "wxyz",// 9
    };

    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits = "23";
        System.out.println(solution.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ret;
        }
        dfs(digits, 0, ret, new StringBuffer());
        return ret;
    }

    private void dfs(String digits, int index, List<String> ret, StringBuffer sb) {
        if (index == digits.length()) {
            ret.add(sb.toString());
            return;
        }

        int num = Character.getNumericValue(digits.charAt(index));
        char[] chars = letters[num].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            dfs(digits, index + 1, ret, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
