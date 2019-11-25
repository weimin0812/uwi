package swordoffer.question28;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 数组中有一个数字出现的次数超过数组长度的一半，
    // 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
    // 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
    public int MoreThanHalfNum_Solution1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0, maxValue = 0;
        for (int n : array) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (maxCount < map.get(n)) {
                maxCount = map.get(n);
                maxValue = n;
            }
        }
        return maxCount > array.length / 2 ? maxValue : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(solution.MoreThanHalfNum_Solution(array));
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        // todo o(n) method
        if (array == null || array.length == 0) {
            return 0;
        }
        int ret = array[0], count = 1;
        for (int i = 1; i < array.length; i++) {
            if (ret == array[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                ret = array[i];
                count = 1;
            }
        }
        count = 0;
        for (int i : array) {
            if (i == ret) {
                count++;
            }
        }
        return count > array.length / 2 ? ret : 0;
    }
}
