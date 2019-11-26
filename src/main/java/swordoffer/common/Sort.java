package swordoffer.common;

public class Sort {
    public static void main(String[] args) {
        Sort sort = new Sort();
        for (int i = 0; i < 100; i++) {
            int[] array = sort.generateArray();
            sort.heapSort(array);
            System.out.println(sort.isSorted(array));
            if (!sort.isSorted(array)) {
                System.out.println("Error");
                break;
            }
        }

    }

    private void heapSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        // heapify
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            heapify(array, i, array.length - 1);
        }

        // sort
        for (int i = array.length - 1; i >= 0; i--) {
            int t = array[0];
            array[0] = array[i];
            array[i] = t;
            heapify(array, 0, i - 1);
        }
    }

    private void heapify(int[] array, int currentIndex, int lastIndex) {
        int leftIndex = currentIndex * 2 + 1;
        while (leftIndex <= lastIndex) {
            int rightIndex = currentIndex * 2 + 2, largerIndex = leftIndex;
            if (rightIndex <= lastIndex && array[rightIndex] > array[leftIndex]) {
                largerIndex = rightIndex;
            }
            if (array[currentIndex] >= array[largerIndex]) {
                break;
            }
            int t = array[currentIndex];
            array[currentIndex] = array[largerIndex];
            array[largerIndex] = t;
            currentIndex = largerIndex;
            leftIndex = currentIndex * 2 + 1;
        }

    }


    private void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int l, int h) {
        if (l < h) {
            int i = partition(array, l, h);
            quickSort(array, l, i - 1);
            quickSort(array, i + 1, h);
        }
    }

    private int partition(int[] array, int l, int h) {
        int pivot = array[l];
        while (l < h) {
            while (l < h && array[h] >= pivot) {
                h--;
            }
            array[l] = array[h];
            while (l < h && array[l] < pivot) {
                l++;
            }
            array[h] = array[l];
        }
        array[l] = pivot;
        return l;
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
}
