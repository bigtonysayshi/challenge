package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    // Time: O(nlogn) Space: O(k)
    public List<Integer> topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k,
                (int[] p1, int[] p2) -> p1[1] - p2[1]);
        int prev = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                count++;
            } else {
                maxHeap.add(new int[]{prev, count});
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
                prev = nums[i];
                count = 1;
            }
        }
        maxHeap.add(new int[]{prev, count});
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }
        List<Integer> topK = new ArrayList<>(k);
        maxHeap.stream().forEach(p -> topK.add(p[0]));
        return topK;
    }

    public static void main(String[] args){
        TopKFrequentElements instance = new TopKFrequentElements();
        System.out.println(instance.topKFrequent(new int[]{1,1,2,3,3,4}, 2));
    }
}
