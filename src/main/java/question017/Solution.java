package question017;

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
        dfs(ret, digits, 0, new StringBuffer());
        return ret;
    }

    private void dfs(List<String> ret, String digits, int i, StringBuffer sb) {
        if (i == digits.length()) {
            ret.add(sb.toString());
            return;
        }

        int index = Character.getNumericValue(digits.charAt(i));
        char[] chars = letters[index].toCharArray();

        for (int j = 0; j < chars.length; j++) {
            sb.append(chars[j]);
            dfs(ret, digits, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
