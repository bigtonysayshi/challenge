package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h.
 * Write an algorithm to reconstruct the queue.
 * Note: The number of people is less than 1,100.
 */
public class QueueReconstructionByHeight {
    // Sort by height descending and then inserting to queue at idx = k
    //Time: O(n^2) Space: O(n)
    public int[][] reconstructQueue(int[][] people) {
        int m = people.length;
        ArrayList<int[]> queue = new ArrayList<>();
        if (m == 0) return new int[m][2];
        Arrays.sort(people, (int[] l1, int[] l2) ->
                l1[0] == l2[0] ? l1[1] - l2[1] : l2[0] - l1[0]);
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        int[][] result = new int[m][2];
        for (int i = 0; i < m; i++) {
            result[i] = queue.get(i);
        }
        return result;
    }

    public static void main(String[] args){
        int[][] input = new int[][]{
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };
        QueueReconstructionByHeight instance = new QueueReconstructionByHeight();
        System.out.println(Arrays.toString(instance.reconstructQueue(input)));
    }
}
