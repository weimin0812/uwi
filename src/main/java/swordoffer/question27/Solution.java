package swordoffer.question27;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    // todo
    // 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
    // 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
    // 输入描述:
    // 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.isEmpty()) {
            return ret;
        }
        dfs(str, 0, new StringBuilder(), new boolean[str.length()]);
        Collections.sort(ret);
        return ret;
    }

    private void dfs(String str, int index, StringBuilder sb, boolean[] visited) {
        if (index == str.length()) {
            ret.add(sb.toString());
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) {
                visited[i] = true;
                sb.append(str.charAt(i));
                dfs(str, index + 1, sb, visited);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
