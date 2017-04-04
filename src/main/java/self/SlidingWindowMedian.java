package self;

import java.util.*;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Your job is to output the median array for each window in the original array.
 */
public class SlidingWindowMedian {
    class Node implements Comparable<Node> {
        int idx;
        int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Node other) {
            if (this.val == other.val) {
                return Integer.compare(this.idx, other.idx);
            }
            return Integer.compare(this.val, other.val);
        }
    }

    // Time: O(nlogk) Space: O(n)
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> medians = new LinkedList<>();
        TreeSet<Node> minHeap = new TreeSet<>();
        TreeSet<Node> maxHeap = new TreeSet<>();

        int heapCap = (k + 1) / 2;
        for (int i = 0; i < k - 1; i++) {
            insertVal(minHeap, maxHeap, heapCap, new Node(i, nums[i]));
        }

        for (int i = k - 1; i < nums.length; i++) {
            insertVal(minHeap, maxHeap, heapCap, new Node(i, nums[i]));
            if (k % 2 == 1) {
                medians.add((double)minHeap.last().val);
            } else {
                medians.add(((double)minHeap.last().val + (double)maxHeap.first().val) / 2.0);
            }
            Node oldNode = new Node(i - k + 1, nums[i - k + 1]);
            if (minHeap.contains(oldNode)) {
                minHeap.remove(oldNode);
            } else {
                maxHeap.remove(oldNode);
            }
        }
        double[] results = new double[medians.size()];
        for (int i = 0; i < medians.size(); i++) {
            results[i] = medians.get(i);
        }
        return results;
    }

    private void insertVal(TreeSet<Node> minHeap, TreeSet<Node> maxHeap, int cap, Node node) {
        if (minHeap.size() < cap) {
            minHeap.add(node);
        } else {
            maxHeap.add(node);
        }
        if (minHeap.size() == cap) {
            if (!maxHeap.isEmpty() && maxHeap.first().val < minHeap.last().val) {
                Node minNode = minHeap.last();
                Node maxNode = maxHeap.first();
                minHeap.remove(minNode);
                maxHeap.remove(maxNode);
                minHeap.add(maxNode);
                maxHeap.add(minNode);
            }
        }
    }


    public static void main(String[] args){
        SlidingWindowMedian instance = new SlidingWindowMedian();
        System.out.println(Arrays.toString(instance.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(instance.medianSlidingWindow(new int[]{5,2,2,7,3,7,9,0,2,3}, 9)));
        System.out.println(Arrays.toString(instance.medianSlidingWindow(new int[]{-1,-1,1,-1,-1,-1,1,1,1,1,-1,1,-1}, 3)));
        System.out.println(Arrays.toString(instance.medianSlidingWindow(new int[]{
                Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,
                Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE}, 3)));

    }
}


