package swordoffer.question41;

import java.util.ArrayList;

public class Solution {

    // 所有和为S的连续正数序列
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (sum < 3) {
            return ret;
        }
        int l = 1, h = 2;
        // t = (l+h)(h-l+1)/2
        // if t < sum h++,t >sum l++ while(h <= sum)
        while (h < sum) {
            int t = (l + h) * (h - l + 1) / 2;
            if (t == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = l; i <= h; i++) {
                    list.add(i);
                }
                ret.add(list);
                l++;
                h++;
            } else if (t < sum) {
                h++;
            } else {
                l++;
            }
        }
        return ret;
    }
}
