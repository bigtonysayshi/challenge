package self;

/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 */
public class FindPeakElement {
    // Time: O(logn) Space: O(1)
    public int findPeakElement(int[] nums) {
        int n =nums.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid == 0 || mid == n - 1) return nums[lo] > nums[hi] ? lo : hi;
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            if (nums[mid] < nums[mid-1]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args){
        FindPeakElement instance = new FindPeakElement();
        System.out.println(instance.findPeakElement(new int[]{1,2,3,1}));
    }
}
