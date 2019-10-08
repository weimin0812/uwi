package question011g;

public class Solution {
    public int maxArea(int[] height) {
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                ret = Math.max(ret, (j - i) * Math.min(height[i], height[j]));
            }
        }

        return ret;
    }

    public int maxArea1(int[] height) {
        int l = 0, r = height.length - 1, ret = 0;
        while (l < r) {
            ret = Math.max(ret, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return ret;
    }
}
