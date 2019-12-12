package swordoffer.question64;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    //    给定一个数组和滑动窗口的大小，
    //    找出所有滑动窗口里数值的最大值。
    //    例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
    //    那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
    //    针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
    //    {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
    //    {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
    //    {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        Solution solution = new Solution();
        ArrayList<Integer> ret = solution.maxInWindows(nums, 3);
        System.out.println(ret);
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null || size < 1 || size > num.length) {
            return ret;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && i - queue.peek() >= size) {
                queue.poll();
            }
            while (!queue.isEmpty() && num[queue.peekLast()] < num[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= size - 1) {
                ret.add(num[queue.peek()]);
            }
        }
        return ret;
    }
}
