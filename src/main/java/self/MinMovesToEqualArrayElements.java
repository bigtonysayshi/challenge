package self;


/**
 * Given a non-empty integer array of size n,
 * find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.
 */
public class MinMovesToEqualArrayElements {
    // Times: O(n) Space: O(1)
    public int minMoves(int[] nums) {
        int moves = 0, min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        for (int n : nums) moves += n - min;
        return moves;
    }

    public static void main(String[] args){
        MinMovesToEqualArrayElements instance = new MinMovesToEqualArrayElements();
        System.out.println(instance.minMoves(new int[]{1,2,3}));
    }
}
