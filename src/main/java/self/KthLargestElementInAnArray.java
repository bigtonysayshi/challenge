package self;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray {
    // Time: O(nlogn) Space: O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args){
        KthLargestElementInAnArray instance = new KthLargestElementInAnArray();
        System.out.println(instance.findKthLargest(new int[]{1,2,3,3,4,4,4,5,6},4));
        System.out.println(instance.findKthLargest(new int[]{1,2,3,3,4,4,4,5,6},7));
    }
}
