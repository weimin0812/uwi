package swordoffer.question32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {3, 32, 321};
        System.out.println(solution.PrintMinNumber(numbers));
    }

    public String PrintMinNumber(int[] numbers) {
        // 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
        // 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
        if (numbers == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        list.sort((i, j) -> (i + "" + j).compareTo((j + "" + i)));
        return toString(list);
    }
    private String toString(ArrayList<Integer> list) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }


    private List<String> ret = new ArrayList<>();

    public String PrintMinNumber1(int[] numbers) {
        // 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
        // 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
        if (numbers == null) {
            return null;
        }
        dfs(numbers, 0, new ArrayList<Integer>(), new boolean[numbers.length]);
        Collections.sort(ret);
        return ret.get(0);
    }

    private void dfs(int[] numbers, int index, ArrayList<Integer> list, boolean[] visited) {
        if (index == numbers.length) {
            ret.add(toString(list));
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(numbers[i]);
                dfs(numbers, index + 1, list, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }




}
