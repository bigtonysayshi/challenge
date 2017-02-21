package self;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Formally the function should:
 * Return true if there exists i, j, k such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 */
public class IncreasingTripletSubsequence {
    // Time: O(n) Space: O(1)
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int low = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= low) {
                low = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        IncreasingTripletSubsequence instance = new IncreasingTripletSubsequence();
        System.out.println(instance.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(instance.increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(instance.increasingTriplet(new int[]{2,1,5,0,4,6}));
    }
}
