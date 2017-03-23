package self;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Note: You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * Follow up: Could you solve it in linear time?
 */
public class SlidingWindowMaximum {
    // Time: O(n) Space: O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length < k) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int idx = 0;
        Deque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!window.isEmpty() && window.peekFirst() < i - k + 1) {
                window.pollFirst();
            }
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }
            window.offerLast(i);
            if (i - k + 1 >= 0) {
                result[idx++] = nums[window.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args){
        SlidingWindowMaximum instance = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(instance.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
}
