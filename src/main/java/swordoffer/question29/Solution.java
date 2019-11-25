package swordoffer.question29;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = solution.generateArray();
        solution.heapSort(array);
        System.out.println(solution.isSorted(array));
    }

    private int[] generateArray() {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    private boolean isSorted(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public void heapSort(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        // build heap
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            heapify(array, array.length - 1, i);
        }

        // One by one extract an element from heap
        for (int i = array.length - 1; i > 0; i--) {
            int t = array[i];
            array[i] = array[0];
            array[0] = t;
            heapify(array, i - 1, 0);
        }
    }

    private void heapify(int[] array, int lastIndex, int currentIndex) {
        int leftIndex = currentIndex * 2 + 1;
        int rightIndex = currentIndex * 2 + 2;
        while (leftIndex <= lastIndex || rightIndex <= lastIndex) {
            int largerIndex = leftIndex;
            if (rightIndex <= lastIndex && array[leftIndex] < array[rightIndex]) {
                largerIndex = rightIndex;
            }

            if (array[largerIndex] > array[currentIndex]) {
                int t = array[currentIndex];
                array[currentIndex] = array[largerIndex];
                array[largerIndex] = array[currentIndex];
                currentIndex = largerIndex;
                leftIndex = currentIndex * 2 + 1;
                rightIndex = currentIndex * 2 + 2;
            } else {
                break;
            }
        }

    }


    // 最小的K个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // heap sort
        ArrayList<Integer> ret = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length) {
            return ret;
        }
        // 最小的K个数，大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : input) {
            maxHeap.offer(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        ret.addAll(maxHeap);
        return ret;
    }


    // 输入n个整数，找出其中最小的K个数。
    // 例如输入4,5,1,6,2,7,3,8这8个数字，
    // 则最小的4个数字是1,2,3,4。
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        // quick sort
        ArrayList<Integer> ret = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length) {
            return ret;
        }
        int index = partition(input, 0, input.length - 1);
        while (index != k - 1) {
            if (index > k - 1) {
                index = partition(input, 0, index - 1);
            } else {
                index = partition(input, index + 1, input.length - 1);
            }
        }
        for (int i = 0; i < k; i++) {
            ret.add(input[i]);
        }
        return ret;
    }

    // todo quick sort need practice
    // sucks
    private int partition(int[] input, int l, int h) {
        int pivot = input[l];
        while (l < h) {
            while (l < h && input[h] >= pivot) {
                h--;
            }
            input[l] = input[h];
            while (l < h && input[l] < pivot) {
                l++;
            }
            input[h] = input[l];
        }
        input[l] = pivot;
        return l;
    }
}
