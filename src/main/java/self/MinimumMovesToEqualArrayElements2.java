package self;

import java.util.Arrays;

/**
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 * You may assume the array's length is at most 10,000.
 */
public class MinimumMovesToEqualArrayElements2 {
    // Time: O(nlogn) Space: O(1)
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            moves += nums[j--] - nums[i++];
        }
        return moves;
    }

    public static void main(String[] args){
        MinimumMovesToEqualArrayElements2 instance = new MinimumMovesToEqualArrayElements2();
        System.out.println(instance.minMoves2(new int[]{1,2,3}));
        System.out.println(instance.minMoves2(new int[]{1,1,1,1,3,3}));
    }
}
