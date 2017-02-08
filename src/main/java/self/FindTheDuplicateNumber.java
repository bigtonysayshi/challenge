package self;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindTheDuplicateNumber {
    // Time: O(n) Space: O(1)
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        for (int i = 0; i < n + 1; i++) {
            int next = nums[n];
            int tmp = nums[next-1];
            if (next == tmp) return next;
            nums[next-1] = next;
            nums[n] = tmp;
        }
        return -1;
    }

    public static void main(String[] args){
        FindTheDuplicateNumber instance = new FindTheDuplicateNumber();
        System.out.println(instance.findDuplicate(new int[]{1,1,1,4,5,2}));
        System.out.println(instance.findDuplicate(new int[]{3,1,2,3,3}));
    }
}
