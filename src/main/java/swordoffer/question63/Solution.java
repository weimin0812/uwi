package swordoffer.question63;

import java.util.PriorityQueue;

public class Solution {
    //    如何得到一个数据流中的中位数？
//    如果从数据流中读出奇数个数值，
//    那么中位数就是所有数值排序之后位于中间的数值。
//    如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
//    我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
    // 小顶堆堆顶元素最小、大顶堆堆顶元素最大
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j) -> j.compareTo(i));
    private int count = 0;

    public void Insert(Integer num) {
        count++;
        if (count % 2 == 1) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    public Double GetMedian() {
        if (count % 2 == 1) {
            return minHeap.peek() * 1.0;
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
