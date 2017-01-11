package self;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size,
 * calculate the moving average of all integers in the sliding window.
 */
public class MovingAverageFromDataStreams {
    public static void main(String[] args){
        MovingAverage instance = new MovingAverage(3);
        System.out.println(instance.next(1));
        System.out.println(instance.next(10));
        System.out.println(instance.next(3));
        System.out.println(instance.next(5));
    }
}

class MovingAverage {
    private int size;
    private Queue<Integer> elements;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        elements = new LinkedList<>();
    }

    public double next(int val) {
        if (elements.size() >= size) {
            elements.poll();
        }
        elements.add(val);
        return getAvg();
    }

    private double getAvg() {
        double sum = 0.0;
        for (int e : elements) {
            sum += e;
        }
        return sum / elements.size();
    }
}

// Better solution using an array and rotating the insert index
class MovingAverage2 {
    private int [] window;
    private int n, insert;
    private long sum;

    /** Initialize your data structure here. */
    public MovingAverage2(int size) {
        window = new int[size];
        insert = 0;
        sum = 0;
    }

    public double next(int val) {
        if (n < window.length)  n++;
        sum -= window[insert];
        sum += val;
        window[insert] = val;
        insert = (insert + 1) % window.length;

        return (double)sum / n;
    }
}