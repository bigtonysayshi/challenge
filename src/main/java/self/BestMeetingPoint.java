package self;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A group of two or more people wants to meet and minimize the total travel distance.
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
 */
public class BestMeetingPoint {
    // Time: O(mn + klogk) Space: O(mn)
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        return getDistance(rows) + getDistance(cols);
    }

    private int getDistance(List<Integer> vals) {
        Collections.sort(vals);
        int left = 0, right = vals.size() - 1, total = 0;
        while (left < right) {
            total += vals.get(right--) - vals.get(left++);
        }
        return total;
    }

    public static void main(String[] args){
        BestMeetingPoint instance = new BestMeetingPoint();
        System.out.println(instance.minTotalDistance(new int[][]{
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        }));
    }
}
