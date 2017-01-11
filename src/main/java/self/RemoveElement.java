package self;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    // Time: O(n) Space: O(1)
    public int removeElement(int[] nums, int val) {
        int nextIdx = 0;
        for (int n : nums) {
            if (n != val) nums[nextIdx++] = n;
        }
        return nextIdx;
    }

    public static void main(String[] args){
        RemoveElement instance = new RemoveElement();
        System.out.println(instance.removeElement(new int[]{3,2,2,3}, 3));
    }
}
