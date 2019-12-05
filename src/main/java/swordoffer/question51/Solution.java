package swordoffer.question51;

public class Solution {
    // 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] left = new int[A.length], right = new int[A.length], ret = new int[A.length];
        left[0] = 1;
        right[right.length - 1] = 1;
        for (int i = 1; i < left.length; i++) {
            left[i] = A[i - 1] * left[i - 1];
        }
        for (int i = A.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * A[i + 1];
        }
        for (int i = 0; i < ret.length; i++) {
            ret[i] = left[i] * right[i];
        }
        return ret;
    }
}
