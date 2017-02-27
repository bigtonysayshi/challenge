package self;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 */
public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int writeIdx = 1;
        int readIdx = 0;
        int currentVal = nums[readIdx++];
        int currentCount = 1;
        while (readIdx < nums.length) {
            int val = nums[readIdx++];
            if (val == currentVal) {
                if (currentCount == 1) {
                    currentCount++;
                    nums[writeIdx++] = val;
                }
            } else {
                nums[writeIdx++] = val;
                currentVal = val;
                currentCount = 1;
            }
        }
        return writeIdx;
    }

    public static void main(String[] args){
        RemoveDuplicatesFromSortedArray2 instance = new RemoveDuplicatesFromSortedArray2();
        System.out.println(instance.removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(instance.removeDuplicates(new int[]{1,2,3}));
    }
}
