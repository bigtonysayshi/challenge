package self;

import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArrays2 {
    // Time: O(max(m,n)) Space: O(max(m,n))
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int n : nums1) {
            if (freq.containsKey(n)) {
                freq.put(n, freq.get(n) + 1);
            } else {
                freq.put(n, 1);
            }
        }
        List<Integer> intersection = new LinkedList<Integer>();
        for (int n : nums2) {
            if (freq.containsKey(n)) {
                int count = freq.get(n);
                if (count > 0) {
                    intersection.add(n);
                    freq.put(n, count - 1);
                }
            }
        }
        int[] results = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            results[i] = intersection.get(i);
        }
        return results;
    }

    public static void main(String[] args){
        IntersectionOfTwoArrays2 instance = new IntersectionOfTwoArrays2();
        int[] input1 = new int[]{1, 2, 2, 1};
        int[] input2 = new int[]{2, 2};

        System.out.println(Arrays.toString(instance.intersect(input1, input2)));
    }
}
