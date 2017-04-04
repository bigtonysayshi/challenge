package self;

/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 */
public class FindPeakElement {
    // Time: O(logn) Space: O(1)
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[right] > nums[left] ? right : left;
    }

    public static void main(String[] args){
        FindPeakElement instance = new FindPeakElement();
        System.out.println(instance.findPeakElement(new int[]{1,2,3,1}));
    }
}
