package self;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.

 */
public class FindMedianFromDataStream {
    private PriorityQueue<Integer> smallNumbers;
    private PriorityQueue<Integer> largeNumbers;

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        smallNumbers = new PriorityQueue<>(Comparator.reverseOrder());
        largeNumbers = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (smallNumbers.isEmpty() || num <= smallNumbers.peek()) {
            smallNumbers.offer(num);
        } else {
            largeNumbers.offer(num);
        }
        if (smallNumbers.size() > largeNumbers.size() + 1) {
            largeNumbers.offer(smallNumbers.poll());
        } else if (smallNumbers.size() < largeNumbers.size()) {
            smallNumbers.offer(largeNumbers.poll());
        }
    }

    public double findMedian() {
        if (smallNumbers.size() > largeNumbers.size()) {
            return smallNumbers.peek();
        } else {
            return ((long)smallNumbers.peek() + (long)largeNumbers.peek()) / 2.0;
        }
    }
}
