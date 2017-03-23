package self;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the
 * little match girl has, please find out a way you can make one square by using up all those
 * matchsticks. You should not break any stick, but you can link them up,
 * and each matchstick must be used exactly one time.
 * Your input will be several matchsticks the girl has, represented with their stick length.
 * Your output will either be true or false, to represent whether you could make one square using
 * all the matchsticks the little match girl has.
 * Note:
 * The length sum of the given matchsticks is in the range of 0 to 10^9.
 * The length of the given matchstick array will not exceed 15.
 */
public class MatchsticksToSquare {
    public boolean makesquare(int[] nums) {
        int n = nums.length;
        if (n == 0) return false;
        Integer[] sortedNums = new Integer[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sortedNums[i] = nums[i];
        }
        if (sum % 4 != 0) return false;
        Arrays.sort(sortedNums, Comparator.reverseOrder());
        int side = sum / 4;
        boolean[] used = new boolean[n];
        for (int i = 0; i < 4; i++) {
            boolean found = findSum(sortedNums, used, 0, side);
            if (!found) return false;
        }
        for (boolean b : used) {
            if (!b) return false;
        }
        return true;
    }

    private boolean findSum(Integer[] nums, boolean[] used, int start, int target) {
        if (target == 0) return true;
        if (target < 0) return false;
        for (int i = start; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                boolean found = findSum(nums, used, i+1, target - nums[i]);
                if (found) {
                    return true;
                } else {
                    used[i] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        MatchsticksToSquare instance = new MatchsticksToSquare();
        System.out.println(instance.makesquare(new int[]{1,1,2,2,2}));
        System.out.println(instance.makesquare(new int[]{3,3,3,3,4}));
        System.out.println(instance.makesquare(new int[]{3,3,3,3,4,4,4,4,5,5,5,5}));
    }
}
